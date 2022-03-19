package com.backend.pharmacy_management.controller.securityController;



import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.entity.user_role.ERole;
import com.backend.pharmacy_management.model.entity.user_role.Role;
import com.backend.pharmacy_management.model.entity.user_role.User;

import com.backend.pharmacy_management.model.repository.employee.IEmployeeRepository;
import com.backend.pharmacy_management.model.repository.userRepository.RoleRepository;
import com.backend.pharmacy_management.model.repository.userRepository.UserRepository;
import com.backend.pharmacy_management.model.service.userDetailServiceImpl.UserDetailsImpl;
import com.backend.pharmacy_management.payload.reponse.JwtResponse;
import com.backend.pharmacy_management.payload.reponse.MessageResponse;
import com.backend.pharmacy_management.payload.request.LoginRequest;
import com.backend.pharmacy_management.payload.request.SignupRequest;
import com.backend.pharmacy_management.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
@EnableScheduling
public class AuthController {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;


    final String ERORR_MSG = "Error: Role is not found.";

    @PostMapping("/signin")
    public ResponseEntity<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());


        System.out.println(userDetails.getEmployee());
        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getAccountname(),
                userDetails.getEnabled(),
                userDetails.getEmail(),
                userDetails.getEmployee(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponse> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUserName(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }


        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                encoder.encode(signUpRequest.getPassword()));
        user.setAccountName(signUpRequest.getAccountName());
        user.setEmail(signUpRequest.getEmail());
        String newUserCode = this.autoIncrement();
        user.setUserCode(newUserCode);
        user.setEnabled(false);
        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException(ERORR_MSG));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException(ERORR_MSG));
                        roles.add(adminRole);

                        break;
                    case "mod":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException(ERORR_MSG));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException(ERORR_MSG));
                        roles.add(userRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @GetMapping("email/send/{name}/{email}")
    public void sendEmail(@PathVariable Optional<String> name,
                          @PathVariable Optional<String> email) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dayPlusAWeek = LocalDate.now();
        String day = formatter.format(dayPlusAWeek);

        String sendEmail = email.orElse("");
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(sendEmail);
        message.setSubject("Xác thực tài khoản của C0221G1_Pharmacy!!!");
        message.setText("Chào " + name.orElse("") + "\n"
                + "Vui lòng xác nhận đăng ký tài khoản. " + "\n"
               + "Click đường để hoàn thành đăng ký : http://localhost:8080/api/auth/email/success/"+sendEmail);

        this.emailSender.send(message);
    }

    @GetMapping("email/success/{email}")
    public String accuracyEmail(@PathVariable Optional<String> email){
        String getEmail = email.orElse("");
        User user = this.userRepository.findUser(getEmail);
        user.setEnabled(true);
        this.userRepository.save(user);
        return "redirect:/successEmail";
    }



    public String autoIncrement(){
        String code = "KH-";
        String regex = "^KH-[0-9]{4}$";
        int total = this.userRepository.totalOfRecordKH();
        String id = "";
        while (true){
            id = code + (total +1);
            if (id.matches(regex)){
                break;
            }
            code += 0;
            id = "";
        }
        return id;
    }


}
