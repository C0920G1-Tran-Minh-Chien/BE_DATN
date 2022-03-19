package com.backend.pharmacy_management.model.repository.import_bill;

import com.backend.pharmacy_management.model.dto.ListImportDto;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface IListImportDtoRepository extends JpaRepository<ImportBill, Long> {
    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode , " +
            "import_bill.accounting_voucher as accountingVoucher , " +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "where import_bill.flag = 1 " +
            "order by invoiceDate desc limit ?1,5", nativeQuery = true)
    List<ListImportDto> getListImportDto(int index);

    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode, " +
            "import_bill.accounting_voucher as accountingVoucher, " +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id "+
            "where import_bill.flag = 1 " , nativeQuery = true)
    List<ListImportDto> getListImportDtoNotPaging();

    @Query(value = "{call selname2(:billCode, :startDate, :endDate, :col)}", nativeQuery = true)
    List<ListImportDto> searchAndSort(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                      @Param("endDate") String endDate, @Param("col") String col);

    @Query(value = "select * from import_bill left join manufacturer on " +
            " manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            " left join payment on payment.payment_id = import_bill.payment_id " +
            " where import_bill.flag = 1 " +
            " order by import_bill.invoice_date desc ", nativeQuery = true)
    Page<ImportBill> getPageListImportDto(Pageable pageable);

    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode, " +
            "import_bill.accounting_voucher as accountingVoucher, " +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "where import_bill.flag = 1 and systemCode like concat('%',:billCode,'%') and ( invoiceDate between :startDate and :endDate ) " +
            "order by invoiceDate desc ", nativeQuery = true)    List<ListImportDto> searchAndSortPaging(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                            @Param("endDate") String endDate);

    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode, " +
            "import_bill.accounting_voucher as accountingVoucher, " +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "where import_bill.flag = 1 " +
            "order by invoiceDate desc ", nativeQuery = true)
    List<ListImportDto> getAllBill();

    @Transactional
    @Modifying
    @Query(value = "update import_bill set flag = false where import_bill_id=?1 ", nativeQuery = true)
    void deleteImportBill(Long id);

//    @Query(value = "{call selname3(:billCode, :startDate, :endDate, :col, :sort)}", nativeQuery = true)
@Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode, " +
        "import_bill.accounting_voucher as accountingVoucher," +
        "import_bill.invoice_date as invoiceDate, " +
        "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
        "manufacturer.manufacturer_address as manufacturerAddress " +
        "from import_bill " +
        "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
        "left join payment on payment.payment_id = import_bill.payment_id " +
        "where import_bill.flag = 1 and import_bill.import_system_code like concat('%',:billCode,'%') and ( import_bill.invoice_date between :startDate and :endDate ) " +
        "order by invoiceDate desc ", nativeQuery = true)
    List<ListImportDto> searchAndPaging(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                        @Param("endDate") String endDate);
    @Query(value = "select import_bill.import_bill_id as billId,import_bill.import_system_code as systemCode, " +
            "import_bill.accounting_voucher as accountingVoucher, " +
            "import_bill.invoice_date as invoiceDate, " +
            "payment.total_money as totalMoney, (payment.total_money-payment.prepayment) as ownBill, manufacturer.manufacturer_name as manufacturerName, " +
            "manufacturer.manufacturer_address as manufacturerAddress " +
            "from import_bill " +
            "left join manufacturer on manufacturer.manufacturer_id = import_bill.manufacturer_id " +
            "left join payment on payment.payment_id = import_bill.payment_id " +
            "where import_bill.flag = 1 and import_bill.import_system_code like concat('%',:billCode,'%') and ( import_bill.invoice_date between :startDate and :endDate ) " +
            "order by invoiceDate asc ", nativeQuery = true)
    List<ListImportDto> searchAndPaging2(@Param("billCode") String billCode, @Param("startDate") String startDate,
                                        @Param("endDate") String endDate);
}
