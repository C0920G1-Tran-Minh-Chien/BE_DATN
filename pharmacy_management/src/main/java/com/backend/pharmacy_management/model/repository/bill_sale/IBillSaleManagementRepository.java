package com.backend.pharmacy_management.model.repository.bill_sale;

import com.backend.pharmacy_management.model.entity.bill_sale.BillSale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Repository
public interface IBillSaleManagementRepository extends PagingAndSortingRepository<BillSale,Long> {
    @Query(value="select * from bill_sale where flag = 1",nativeQuery = true)
    List<BillSale> findAllBill();

    @Query(value="select * from bill_sale where flag = 1",nativeQuery = true)
    Page<BillSale> findAllBillPage(Pageable pageable);

    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1", nativeQuery = true )
    List<BillSale> findBillBySearch(String search1 , String search2, String search3, String search4 , String search5);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by bill_sale_code desc ", nativeQuery = true )
    List<BillSale> findBillBySearch1(String search1 , String search2, String search3, String search4 , String search5);

    @Query(value = "select * from bill_sale left join customer on bill_sale.customer_id = customer.customer_id where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by customer_name asc ", nativeQuery = true )
    List<BillSale> findBillBySearch2(String search1 , String search2, String search3, String search4 , String search5);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by invoice_date asc ", nativeQuery = true )
    List<BillSale> findBillBySearch3(String search1 , String search2, String search3, String search4 , String search5);
    @Query(value = "select * from bill_sale left join employee on bill_sale.employee_id = employee.employee_id where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by employee_name asc ", nativeQuery = true )
    List<BillSale> findBillBySearch4(String search1 , String search2, String search3, String search4 , String search5);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by total_money asc ", nativeQuery = true )
    List<BillSale> findBillBySearch5(String search1 , String search2, String search3, String search4 , String search5);









    @Query(value="select * from bill_sale where bill_sale_id = ?1 and flag = 1", nativeQuery = true)
    Optional <BillSale> findBillSaleById(long id);

    @Transactional
    @Modifying
    @Query(value = "update bill_sale set flag = 0 where bill_sale_id = ?1", nativeQuery = true)
    void deleteBillById(long id);



    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1", nativeQuery = true )
    Page<BillSale> findBillBySearchPage(String search1 , String search2, String search3, String search4 , String search5 ,Pageable pageable);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by bill_sale_code desc ", nativeQuery = true )
    Page<BillSale> findBillBySearchPage1(String search1 , String search2, String search3, String search4 , String search5,Pageable pageable);

    @Query(value = "select * from bill_sale left join customer on bill_sale.customer_id = customer.id where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by customer_name asc ", nativeQuery = true )
    Page<BillSale> findBillBySearchPage2(String search1 , String search2, String search3, String search4 , String search5,Pageable pageable);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by invoice_date asc ", nativeQuery = true )
    Page<BillSale> findBillBySearchPage3(String search1 , String search2, String search3, String search4 , String search5,Pageable pageable);
    @Query(value = "select * from bill_sale left join employee on bill_sale.employee_id = employee.id where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by employee_name asc ", nativeQuery = true )
    Page<BillSale> findBillBySearchPage4(String search1 , String search2, String search3, String search4 , String search5 ,Pageable pageable);
    @Query(value = "select * from bill_sale where date(invoice_date) between cast(?1 as date) and cast(?2 as date) and time(invoice_date) between cast(?3 as time ) and cast(?4 as time) and bill_sale_type like %?5% and flag = 1 order by total_money asc ", nativeQuery = true )
    Page<BillSale> findBillBySearchPage5(String search1 , String search2, String search3, String search4 , String search5 ,Pageable pageable);


}
