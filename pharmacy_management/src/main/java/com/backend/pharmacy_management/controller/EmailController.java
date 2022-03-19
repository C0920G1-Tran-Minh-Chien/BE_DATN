package com.backend.pharmacy_management.controller;

//import com.lowagie.text.Chunk;
//import com.lowagie.text.Document;
//import com.lowagie.text.Paragraph;
//import com.lowagie.text.pdf.PdfWriter;
import com.backend.pharmacy_management.model.dto.MailDTO;
import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import com.backend.pharmacy_management.model.entity.bill_sale.DrugOfBill;
import com.backend.pharmacy_management.model.entity.customer.Customer;
import com.backend.pharmacy_management.model.entity.employee.Employee;
import com.backend.pharmacy_management.model.service.bill_sale.IBillSaleService;
import com.backend.pharmacy_management.model.service.bill_sale.IDrugOfBillService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Optional;
import java.util.Properties;

@CrossOrigin(origins = "http://localhost:4200/")
@Component
@RestController
@EnableScheduling
public class EmailController {
    @Autowired
    IBillSaleService iBillSaleService;
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    IDrugOfBillService iDrugOfBillService;
    @GetMapping("email/send/{name}/{email}/{listDrug}")
    public void sendEmail(@PathVariable Optional<String> name,
                          @PathVariable Optional<String> email,
                          @PathVariable Optional<String[]> listDrug
                          ) throws UnsupportedEncodingException, MessagingException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dayPlusAWeek = LocalDate.now();
        String day = formatter.format(dayPlusAWeek);
//        System.out.println(Arrays.toString(listDrug.get()));
//        String array = email.orElse("");
//        SimpleMailMessage message = new SimpleMailMessage();
//
//        message.setTo(array);
//        message.setSubject("Đơn thanh toán KhoaChien-Pharma");
//        message.setText("<h1>Chào</h1> " + name.orElse("") + "\n"
//                + "Bạn đã thanh toán thành công đơn hàng ngày: " + day);
//        this.emailSender.send(message);
        String mailContent = "";
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, "UTF-8");
        helper.setFrom("chiennext@gmail.com", "Nhà thuốc KhoaChien-Pharma");
        helper.setTo(email.get());
        helper.setSubject("Thông tin hóa đơn mua hàng tại KHOACHIEN.");
        mailContent = "<p> Chào bạn!</p>\n" +
                "<p>Cảm ơn khách hàng " + name.get() + " đã mua hàng tại KHOACHIEN PHARMA \n" +
                "<table style=\"border-collapse: collapse; border: 1px solid #dee2e6\">\n" +
                "        <tr>\n" +
                "            <th style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\"> STT </th>\n" +
                "            <th style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\"> Tên sản phẩm</th>\n" +
                "            <th style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\"> Số lượng</th>\n" +
                "            <th style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\"> Đơn giá(VND)</th>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">1</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">Macrolid</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">1</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">85,491</td>\n" +
                "        </tr>\n" +
                "        <tr>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">2</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">Cephalosporin</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">2</td>\n" +
                "            <td style=\"padding: 18px;\n" +
                "    border: 1px solid #dee2e6\">57,673</td>\n" +
                "        </tr>\n" +
                "        <tr> <td style=\"padding: 8px;\n" +
                "    border: 1px solid #dee2e6\" colspan=\"4\"> Tổng tiền: 230,837 VND</td></tr>\n" +
                "    </table>" +
                "<p>Thanks and Regards</p>\n" +
                "<hr>" +
                "<div style=\"text-size-adjust: none !important; -ms-text-size-adjust: none !important; -webkit-text-size-adjust: none !important;\"><span style=\"margin: 0px; padding: 0px; line-height: 100%; display: block; font-family: Helvetica, Arial, sans-serif;\"> </span><span style=\"margin:0; padding:0; font-family: Helvetica, Arial, sans-serif; font-size: 15px; line-height:20px; color: #212121; display:block;\">\n" +
                "        <span style=\"font-weight: bold; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">Nhà thuốc KHOACHIEN</span><span style=\"display: inline; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> / </span><span style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\"</span><span style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span><a href=\"mailto:plthienbkdn@gmail.com\"\n" +
                "           style=\"color: rgb(71, 124, 204); text-decoration: none; display: inline;\">chiennext@gmail.com</a><span\n" +
                "                style=\"display: inline; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> / </span><span\n" +
                "                style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">0794197483</span></span>\n" +
                "    <p style=\"margin:0; padding:0; line-height:20px; display:block;width:100%; font-size:1;\"><img src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"508\" height=\"10\" style=\"display: block; width: 100%; height: 5px;\">\n" +
                "    </p><span style=\"margin: 0px; padding: 0px; font-family: Helvetica, Arial, sans-serif; font-size: 15px; line-height: 25px; display: block;\"> <span\n" +
                "            style=\"font-weight: bold; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">KHOACHIEN PHARMA</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\">Office: </span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">(0292) 3 837 838</span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\"> / </span><span\n" +
                "            style=\"color: rgb(33, 33, 33); display: inline; font-family: Helvetica, Arial, sans-serif;\">Fax: </span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">999-9999-999</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\">TP. Đà Nẵng</span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif; display: inline;\"></span> <span\n" +
                "            style=\"display: inline; font-family: Helvetica, Arial, sans-serif;\"><br></span> <span\n" +
                "            style=\"display: block; color: rgb(33, 33, 33); font-family: Helvetica, Arial, sans-serif;\"> <a\n" +
                "            href=\"http://localhost:4200/\" style=\"color: rgb(71, 124, 204); text-decoration: none; display: inline;\"></a></span> <p\n" +
                "            style=\"margin:0; padding:0; line-height:18px; display:block;width:100%; font-size:1;\"> <img\n" +
                "            src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"508\" height=\"10\"\n" +
                "            style=\"display: block; width: 100%; height: 5px;\">\n" +
                "</p> </span> <span\n" +
                "        style=\"margin: 0px; padding: 0px; line-height: 100%; font-size: 1px; display: block; font-family: Helvetica, Arial, sans-serif;\"> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H25Y6K\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"twitter.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/twitter.png\"\n" +
                "                                                                                                       alt=\"Twitter\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H1N6GV\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"facebook.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/facebook.png\"\n" +
                "                                                                                                       alt=\"Facebook\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H2J2VT\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"linkedin.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/linkedin.png\"\n" +
                "                                                                                                       alt=\"LinkedIn\"></a> <span\n" +
                "        style=\"white-space: nowrap; font-family: Helvetica, Arial, sans-serif; display: inline;\"> <img\n" +
                "        src=\"https://s3.amazonaws.com/htmlsig-assets/spacer.gif\" width=\"2\"> </span> <a\n" +
                "        style=\"text-decoration: none; display: inline;\" href=\"https://htmlsig.com/t/000001H13TNJ\"><img width=\"25\"\n" +
                "                                                                                                       style=\"margin-bottom:2px; border:none; display:inline;\"\n" +
                "                                                                                                       height=\"25\"\n" +
                "                                                                                                       data-filename=\"youtube.png\"\n" +
                "                                                                                                       src=\"https://s3.amazonaws.com/htmlsig-assets/round/youtube.png\"\n" +
                "                                                                                                       alt=\"Youtube\"></a>\n" +
                "</span>\n" +
                "</div>";
        helper.setText(mailContent, true);
        emailSender.send(message);
        BillSale billSale = new BillSale("HDBL100", new Date().toString(), "Mua Online", "Bán online", true, 230100, new Employee(2L), new Customer(1L) );
        this.iBillSaleService.save(billSale);

    }
//
//    spring.mail.host=smtp.gmail.com
//    spring.mail.port=587
//    spring.mail.username=c0221g1drug@gmail.com
//    spring.mail.password=12345678c@
//            spring.mail.properties.mail.smtp.auth=true
//    spring.mail.properties.mail.smtp.starttls.enable=true
    //#region Email + PDF
//    @GetMapping("email/test")
//    public void email() {
//        String smtpHost = "yourhost.com"; //replace this with a valid host
//        int smtpPort = 587; //replace this with a valid port
//
//        String sender = "sender@yourhost.com"; //replace this with a valid sender email address
//        String recipient = "recipient@anotherhost.com"; //replace this with a valid recipient email address
//        String content = "dummy content"; //this will be the text of the email
//        String subject = "dummy subject"; //this will be the subject of the email
//
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", smtpHost);
//        properties.put("mail.smtp.port", smtpPort);
//        Session session = Session.getDefaultInstance(properties, null);
//
//        ByteArrayOutputStream outputStream = null;
//
//        try {
//            //construct the text body part
//            MimeBodyPart textBodyPart = new MimeBodyPart();
//            textBodyPart.setText(content);
//
//            //now write the PDF content to the output stream
//            outputStream = new ByteArrayOutputStream();
//            writePdf(outputStream);
//            byte[] bytes = outputStream.toByteArray();
//
//            //construct the pdf body part
//            DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");
//            MimeBodyPart pdfBodyPart = new MimeBodyPart();
//            pdfBodyPart.setDataHandler(new DataHandler(dataSource));
//            pdfBodyPart.setFileName("test.pdf");
//
//            //construct the mime multi part
//            MimeMultipart mimeMultipart = new MimeMultipart();
//            mimeMultipart.addBodyPart(textBodyPart);
//            mimeMultipart.addBodyPart(pdfBodyPart);
//
//            //create the sender/recipient addresses
//            InternetAddress iaSender = new InternetAddress(sender);
//            InternetAddress iaRecipient = new InternetAddress(recipient);
//
//            //construct the mime message
//            MimeMessage mimeMessage = new MimeMessage(session);
//            mimeMessage.setSender(iaSender);
//            mimeMessage.setSubject(subject);
//            mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient);
//            mimeMessage.setContent(mimeMultipart);
//
//            //send off the email
//            Transport.send(mimeMessage);
//
//            System.out.println("sent from " + sender +
//                    ", to " + recipient +
//                    "; server = " + smtpHost + ", port = " + smtpPort);
//        } catch(Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            //clean off
//            if(null != outputStream) {
//                try { outputStream.close(); outputStream = null; }
//                catch(Exception ex) { }
//            }
//        }
//    }
//
//    public void writePdf(OutputStream outputStream) throws Exception {
//        Document document = new Document();
//        PdfWriter.getInstance(document, outputStream);
//        document.open();
//        Paragraph paragraph = new Paragraph();
//        paragraph.add(new Chunk("hello!"));
//        document.add(paragraph);
//        document.close();
//    }
}
