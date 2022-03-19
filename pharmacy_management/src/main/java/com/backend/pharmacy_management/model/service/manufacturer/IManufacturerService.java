
package com.backend.pharmacy_management.model.service.manufacturer;
import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface IManufacturerService {
    Page<Manufacturer> findAllManufacturer(Pageable pageable);
    Page<Manufacturer> findByManufacturerName( String name,Pageable pageable);
    Page<Manufacturer> findByManufacturerCode(String code,Pageable pageable );
    Page<Manufacturer> findByManufacturerAddress( String address,Pageable pageable);
    Page<Manufacturer> findByManufacturerPhoneNumber( String phoneNumber,Pageable pageable);
    Manufacturer findByManufacturerId( Long id);
    Page<Manufacturer> findByManufacturerNote( String note,Pageable pageable);
    Manufacturer saveManufacturer(Manufacturer manufacturer);
    void deleteManufacturer(Long id);

    Page<Manufacturer> findAllSortName(Pageable pageable);

    Page<Manufacturer> findAllSortCode(Pageable pageable);

    Page<Manufacturer> findAllSortAddress(Pageable pageable);

    Page<Manufacturer> findAllSortNote(Pageable pageable);

    Page<Manufacturer> findAllSortPhoneNumber(Pageable pageable);
    Page<ImportBill> findByIdManufacturer(Long id,Pageable pageable);
    ImportBill findByIdImportBill(Long id);
    Page<ImportBill> findByDateImportBill(Long id,String startDate, String endDate,Pageable pageable);
    List<Manufacturer> getAll();
    Optional<Manufacturer> findByIdM(Long id);


}