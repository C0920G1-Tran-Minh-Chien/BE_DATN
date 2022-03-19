package com.backend.pharmacy_management.model.service.export;

import com.backend.pharmacy_management.model.entity.export_bill.ExportBill;
import com.backend.pharmacy_management.model.entity.export_bill.ExportBillDetail;
import com.backend.pharmacy_management.model.repository.export.ExportBillDetailRepository;
import com.backend.pharmacy_management.model.repository.export.ExportBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ExportBillImpl implements ExportBillService {
    @Autowired
    private ExportBillRepository exportBillRepository;
    @Autowired
    private ExportBillDetailRepository exportBillDetailRepository;


    private final Random rand = SecureRandom.getInstanceStrong();

    public ExportBillImpl() throws NoSuchAlgorithmException {

        // chú thích
    }


    @Override
    public List<String> getAllExportBillCode() {
        return this.exportBillRepository.getAllExportBillCode();
    }

    @Override
    public void createExportBill(ExportBill exportBill) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        exportBill.setExportBillDate(dateFormat.format(new Date()));
        this.exportBillRepository.save(exportBill);
    }

    @Override
    public void createExportBillDetail(ExportBillDetail exportBillDetail) {
        this.exportBillDetailRepository.save(exportBillDetail);
    }
    @Override
    public String createExportBillRefundCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuilder stringCode;
        do {
            stringCode = new StringBuilder("HDXT");
            for(int i = 0; i < 5; i++) {
                stringCode.append(rand.nextInt(9));
            }
        }while (listCode.contains(stringCode.toString()));
        return stringCode.toString();
    }

    @Override
    public String createExportBillDestroyCode() {
        List<String> listCode = getAllExportBillCode();
        StringBuilder result ;
        do {
            result = new StringBuilder("HDXH");
            for (int i = 0; i < 5; i++) {
                result.append(rand.nextInt(9));
            }
        } while (!listCode.isEmpty() && listCode.contains(result.toString()));
        return result.toString();
    }

    @Override
    public Page<ExportBill> findAll(Pageable pageable) {
        return this.exportBillRepository.findAll(pageable);
    }
    @Override
    public ExportBill findById(long id) {
        return this.exportBillRepository.findById(id).orElse(null);
    }

    @Override
    public Page<ExportBill> findByFields(String dateCreate, String toDate, String timeCreate, String toTime, Long idType, Pageable pageable) throws ParseException {
        long typeId = idType;
        if (typeId == 0){
            if (dateCreate.equals(toDate) && dateCreate.equals("2021-01-01")) {
                return this.exportBillRepository.findByTimeFields1(timeCreate, toTime, pageable);
            } else if (dateCreate.equals(toDate)  && !dateCreate.equals("2021-01-01")) {
                return this.exportBillRepository.findByTimeFieldsWith1Day1(timeCreate, toTime, dateCreate, pageable);
            } else if (timeCreate.equals(toTime)  && timeCreate.equals("00:00")) {
                return this.exportBillRepository.findByDateFields1(dateCreate, toDate, pageable);
            } else if (timeCreate.equals(toTime)  && !timeCreate.equals("00:00")) {
                return this.exportBillRepository.findByDateFieldsWith1Time1(dateCreate, toDate, timeCreate, pageable);
            } else if (dateCreate.equals(toDate) && dateCreate.equals("2021-01-01")  && timeCreate.equals(toTime)  && timeCreate.equals("00:00") ){
                return this.exportBillRepository.findAll(pageable);
            }
            return this.exportBillRepository.findBy4Fields1(dateCreate, toDate, timeCreate, toTime, pageable);
        } else {
            if (dateCreate.equals(toDate)  && dateCreate.equals("2021-01-01") ) {
                return this.exportBillRepository.findByTimeFields2(timeCreate, toTime, typeId, pageable);
            } else if (dateCreate.equals(toDate)  && !dateCreate.equals("2021-01-01") ) {
                return this.exportBillRepository.findByTimeFieldsWith1Day2(timeCreate, toTime, dateCreate, typeId, pageable);
            } else if (timeCreate.equals(toTime)  && timeCreate.equals("00:00")  ) {
                return this.exportBillRepository.findByDateFields2(dateCreate, toDate, typeId, pageable);
            } else if (timeCreate.equals(toTime)  && !timeCreate.equals("00:00") ) {
                return this.exportBillRepository.findByDateFieldsWith1Time2(dateCreate, toDate, timeCreate, typeId, pageable);
            } else if (dateCreate.equals(toDate)  && dateCreate.equals("2021-01-01")  && timeCreate.equals(toTime)  && timeCreate.equals("00:00") ){
                return this.exportBillRepository.findByType2(typeId, pageable);
            }
            return this.exportBillRepository.findBy4Fields2(dateCreate, toDate, timeCreate, toTime, typeId, pageable);
        }
    }

    @Override
    public void delete(long id) {
        this.exportBillRepository.deleteExportBillById(id);
    }

}
