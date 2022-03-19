
package com.backend.pharmacy_management.model.repository.import_bill;

import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IImportBillRepository extends JpaRepository<ImportBill,Long> {
    @Query(value = "select * from import_bill", nativeQuery = true)
     List<ImportBill> getListNormals();
    @Query(value="select * from import_bill join manufacturer on manufacturer.manufacturer_id=import_bill.manufacturer_id join payment on payment.import_bill_id=import_bill.import_bill_id where manufacturer.manufacturer_id = ?1", nativeQuery = true)
    Page<ImportBill> findAllByImportBill(Long id, Pageable pageable);
    @Query(value="select * from import_bill join payment on payment.import_bill_id=import_bill.import_bill_id  where payment.import_bill_id = ?1", nativeQuery = true)
    ImportBill findByIdImportBill(Long id);
    @Query(value="select * from import_bill join manufacturer on manufacturer.manufacturer_id=import_bill.manufacturer_id where  manufacturer.manufacturer_id = ?1 and import_bill.invoice_date between ?2 and ?3", nativeQuery = true)
    Page<ImportBill> findByDateImportBill(Long id, String startDate, String endDate,Pageable pageable);
    @Query(value = "select * from import_bill where manufacture_id = ?1",nativeQuery = true)
    List<ImportBill> findByIdManufacturer(Long id);
}

