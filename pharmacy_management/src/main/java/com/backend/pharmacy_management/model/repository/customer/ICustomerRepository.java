
package com.backend.pharmacy_management.model.repository.customer;


import com.backend.pharmacy_management.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select * " +
            "from customer " +
            "where (customer_code like ?1) " +
            "and (customer_name like ?2) " +
            "and (customer_address like ?3) " +
            "and (customer_phone like ?4) " +
            "and (customer_group_id like ?5) "
            + "and (flag = 1)"
            , nativeQuery = true)
    Page<Customer> findALlCusByKey (String code, String name, String address, String phone, String groupId, Pageable pageable);

    @Query(value = "select * " +
            "from customer " +
            "where (customer_code like ?1) " +
            "or (customer_name like ?2) " +
            "or (customer_address like ?3) " +
            "or (customer_phone like ?4) " +
            "or (customer_group_id like ?5) "
            + "and (flag = 1)"
            , nativeQuery = true)
    Page<Customer> findALlCustomersByKey (String code, String name, String address, String phone, String groupId, Pageable pageable);


    @Query(value = "select * from customer where flag = true", nativeQuery = true)
    List<Customer> getAllCustomer();

    @Query(value = "select * from customer where flag = true limit :index,5", nativeQuery = true)
    List<Customer> getCustomerPagination(@Param("index") int index);

    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_id = :id", nativeQuery = true)
    Optional<Customer> findById(@Param("id") Long id);

    @Query(value = "select * from customer\n" +
            "where customer_name like %:keyword%\n" +
            " or customer_age like %:keyword%\n" +
            " or customer_code like %:keyword%\n" +
            " or customer_address like %:keyword%\n" +
            " or customer_phone like %:keyword%\n", nativeQuery = true)
    List<Customer> findCustomerBySearch(@Param("keyword") String keyWord);

    ///search limit 5///////////////////////////////////////
    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_code\n" +
            "like %:keyword% " +
            "LIMIT :index , 5", nativeQuery = true)
    List<Customer> findCustomerByCustomerCode(@Param("index") int index, @Param("keyword") String keyWord);

    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_group\n" +
            "like %:keyword% " +
            "LIMIT :index,5", nativeQuery = true)
    List<Customer> findCustomerByCustomerGroup(@Param("index") int index, @Param("keyword") String keyWord);

    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_name\n" +
            "like %:keyword% " +
            "LIMIT :index,5"
            , nativeQuery = true)
    List<Customer> findCustomerByCustomerName(@Param("index") int index, @Param("keyword") String keyWord);

    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_address\n" +
            "like %:keyword% " +
            "LIMIT :index , 5", nativeQuery = true)
    List<Customer> findCustomerByCustomerAddress(@Param("index") int index, @Param("keyword") String keyWord);

    @Query(value = "select * \n" +
            "from customer\n" +
            "where customer_phone\n" +
            "like %:keyword% " +
            "LIMIT :index,5", nativeQuery = true)
    List<Customer> findCustomerByCustomerPhone(@Param("index") int index, @Param("keyword") String keyWord);
    ///get number of record///////////////////////////////////////

    @Query(value = "select count(*) " +
            " from customer " +
            " where customer_code " +
            "like %:keyword% ", nativeQuery = true)
    Integer findNumberOfRecordCustomerCode(@Param("keyword") String keyWord);

    @Query(value = "select count(*) " +
            " from customer " +
            " where customer_name " +
            "like %:keyword% ", nativeQuery = true)
    Integer findNumberOfRecordCustomerName(@Param("keyword") String keyWord);

    @Query(value = "select count(*) " +
            " from customer " +
            " where customer_address " +
            "like %:keyword% ", nativeQuery = true)
    Integer findNumberOfRecordCustomerAddress(@Param("keyword") String keyWord);

    @Query(value = "select count(*) " +
            " from customer " +
            " where customer_phone " +
            "like %:keyword% ", nativeQuery = true)
    Integer findNumberOfRecordCustomerPhone(@Param("keyword") String keyWord);

    @Query(value = "select * from customer where customer_group_id = 1",nativeQuery = true)
    List<Customer> getAllCustomerWholeSale();

}

