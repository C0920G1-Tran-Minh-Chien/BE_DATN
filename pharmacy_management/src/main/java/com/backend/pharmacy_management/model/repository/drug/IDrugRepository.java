package com.backend.pharmacy_management.model.repository.drug;

import com.backend.pharmacy_management.model.dto.ListDrugDTO;
import com.backend.pharmacy_management.model.entity.drug.Drug;
import com.backend.pharmacy_management.model.dto.DrugDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
@Repository
public interface IDrugRepository extends JpaRepository<Drug, Long> {


    @Query(value = "select * from drug  " , nativeQuery = true)
    List<ListDrugDTO> findAllDrugCTM();


    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/(sum(ibd.import_amount)))/d.conversion_rate) as retailPrice,\n" +
            " (sum(ibd.discount_rate*ibd.import_amount))/(sum(ibd.import_amount)) as discountRate, (sum(ibd.vat*ibd.import_amount))/(sum(ibd.import_amount)) as vat, \n" +
            " (sum(ibd.import_price*ibd.import_amount))/(sum(ibd.import_amount)) as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount*ibd.import_amount))/(sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_side_effect as drugSideEffect, dg.drug_group_name as drugGroup " +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 and dg.flag = 1 and d.drug_name like concat('%', :nameDrug, '%') and d.drug_group_id like concat('%', :drugGroup, '%') and d.active_element like concat('%', :activeElement, '%')" +
            "group by d.drug_id order by d.drug_name limit :index,5;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsPagination(@Param("index") int index, @Param("nameDrug") String nameDrug, @Param("drugGroup") String drugGroup,@Param("activeElement") String activeElement);


    @Query(value = "call drug_search_patination (:field,:sign,:input,:index)", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsSearch(String field, String sign, String input, String index);
    @Query(value = "call drug_search_not_patination (:field,:sign,:input)", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsSearchNotPagination(String field, String sign, String input);

    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/(sum(ibd.import_amount)))/d.conversion_rate) as retailPrice,\n" +
            " (sum(ibd.discount_rate*ibd.import_amount))/(sum(ibd.import_amount)) as discountRate, (sum(ibd.vat*ibd.import_amount))/(sum(ibd.import_amount)) as vat, \n" +
            " (sum(ibd.import_price*ibd.import_amount))/(sum(ibd.import_amount)) as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount*ibd.import_amount))/(sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_side_effect as drugSideEffect, dg.drug_group_name as drugGroup " +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 and dg.flag = 1 and d.drug_name like concat('%', :nameDrug, '%') and d.drug_group_id like concat('%', :drugGroup, '%') and d.active_element like concat('%', :activeElement, '%')" +
            "group by d.drug_id order by d.drug_name;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsNotPagination( @Param("nameDrug") String nameDrug, @Param("drugGroup") String drugGroup,@Param("activeElement") String activeElement );

    @Query(value = "select d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_group_id as drugGroupId, d.flag as flag, d.drug_side_effect as drugSideEffect\n" +
            "from drug d \n" +
            "where d.flag = 1 and d.drug_id = ?1 ;", nativeQuery = true)
    DrugDTO findDrugById(Long id);

    @Modifying
    @Transactional
    @Query(value = "update drug set flag = 0 where drug_id = ?1 ",nativeQuery = true)
    void deleteDrugById(Long id);

    @Modifying
    @Transactional
    @Query(value = "insert into drug (drug_code,drug_name,active_element,unit,conversion_unit," +
            "conversion_rate,wholesale_profit_rate,retail_profit_rate,drug_faculty,manufacturer," +
            "origin,note,flag,drug_side_effect) values (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10,?11,?12,?13,?14)",nativeQuery = true)
    void createDrug(Long drugCode,String drugName,String activeElement,String unit,
                    String conversionUnit,Integer conversionRate,Double wholesaleProfitRate,
                    Double retailProfitRate,String drugFaculty,String manufacturer,String origin,
                    String note,Boolean flag,String drugSideEffect);


    //Đức
    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/(sum(ibd.import_amount)))/d.conversion_rate) as retailPrice,\n" +
            " (sum(ibd.discount_rate*ibd.import_amount))/(sum(ibd.import_amount)) as discountRate, (sum(ibd.vat*ibd.import_amount))/(sum(ibd.import_amount)) as vat, \n" +
            " (sum(ibd.import_price*ibd.import_amount))/(sum(ibd.import_amount)) as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount*ibd.import_amount))/(sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "d.note as note, d.drug_side_effect as drugSideEffect " +
            "from drug d \n" +
            "left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "where d.flag = 1 " +
            "group by d.drug_id order by d.drug_name;", nativeQuery = true)
    List<ListDrugDTO> findAllDrugsGetPrice();

    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "            ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/(sum(ibd.import_amount)))/d.conversion_rate) as retailPrice,\n" +
            "            (sum(ibd.discount_rate*ibd.import_amount))/(sum(ibd.import_amount)) as discountRate, (sum(ibd.vat*ibd.import_amount))/(sum(ibd.import_amount)) as vat,\n" +
            "            (sum(ibd.import_price*ibd.import_amount))/(sum(ibd.import_amount)) as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount*ibd.import_amount))/(sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, dob.quantity  as conversionRate,\n" +
            "            d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "            d.note as note, d.drug_side_effect as drugSideEffect\n" +
            "            from drug d\n" +
            "            left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "            left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "            left join drug_of_bill dob on d.drug_id = dob.drug_id\n" +
            "            left join bill_sale bs on bs.bill_sale_id = dob.bill_sale_id\n" +
            "\t\t\twhere concat(bs.bill_sale_code, bs.bill_sale_id) = ?1\n" +
            "            group by dob.drug_of_bill_id;",nativeQuery = true)
    List<ListDrugDTO> findAllDrugsOfListGetPrice(String id);


    @Query(value = "select ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.wholesale_profit_rate/100))*ibd.import_amount))/(sum(ibd.import_amount))) as wholesalePrice,\n" +
            "            ((sum((ibd.import_price*(1-ibd.discount_rate/100)*(1+ibd.vat/100)*(1+d.retail_profit_rate/100))*ibd.import_amount)/(sum(ibd.import_amount)))/d.conversion_rate) as retailPrice,\n" +
            "             (sum(ibd.discount_rate*ibd.import_amount))/(sum(ibd.import_amount)) as discountRate, (sum(ibd.vat*ibd.import_amount))/(sum(ibd.import_amount)) as vat,\n" +
            "             (sum(ibd.import_price*ibd.import_amount))/(sum(ibd.import_amount)) as importPrice, d.drug_id as drugId, d.drug_code as drugCode, d.drug_name as drugName, d.active_element as activeElement, (sum(ibd.import_amount*ibd.import_amount))/(sum(ibd.import_amount)) as drugAmount, d.unit as unit, d.conversion_unit as conversionUnit, d.conversion_rate as conversionRate,\n" +
            "            d.wholesale_profit_rate as wholesaleProfitRate, d.retail_profit_rate as retailProfitRate, d.drug_faculty as drugFaculty, d.manufacturer as manufacturer, d.origin as origin,\n" +
            "            d.note as note, d.drug_side_effect as drugSideEffect" +
            "            from drug d \n" +
            "            left join drug_group dg on d.drug_group_id = dg.drug_group_id\n" +
            "            left join import_bill_drug ibd on d.drug_id = ibd.drug_id\n" +
            "            where d.drug_id = ? \n" +
            "            group by d.drug_id order by d.drug_name;",nativeQuery = true)
    ListDrugDTO findDrugByIdGetPrice(String id);



}
