
package com.backend.pharmacy_management.model.service.manufacturer.impl;


import com.backend.pharmacy_management.model.entity.import_bill_payment.ImportBill;
import com.backend.pharmacy_management.model.entity.manufacturer.Manufacturer;
import com.backend.pharmacy_management.model.repository.import_bill.IImportBillRepository;
import com.backend.pharmacy_management.model.repository.manufacturer.ManufacturerRepository;
import com.backend.pharmacy_management.model.service.manufacturer.IManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ManufacturerServiceImpl implements IManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;
    @Autowired
    IImportBillRepository importBillRepository;

    @Override
    public Page<Manufacturer> findAllManufacturer(Pageable pageable) {
        return manufacturerRepository.findAllManufacturer(pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerName(String name,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerName( name,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerCode( String code,Pageable pageable) {
        return manufacturerRepository.findByManufacturerCode( code,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerAddress(String address,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerAddress( address,pageable);
    }

    @Override
    public Page<Manufacturer> findByManufacturerPhoneNumber(String phoneNumber,Pageable pageable ) {
        return manufacturerRepository.findByManufacturerPhoneNumber(phoneNumber,pageable);
    }

    @Override
    public Manufacturer findByManufacturerId(Long id) {
        return manufacturerRepository.findById(id).orElse(null);
    }

    @Override
    public Page<Manufacturer> findByManufacturerNote( String node,Pageable pageable) {
        return manufacturerRepository.findByManufacturerNote( node,pageable);
    }

    @Override
    public Manufacturer saveManufacturer(Manufacturer manufacturer) {
      return   manufacturerRepository.save(manufacturer);



    }

    @Override
    public void deleteManufacturer(Long id) {
         manufacturerRepository.deleteByIdManufacturer(id);
    }

    @Override
    public Page<Manufacturer> findAllSortName(Pageable pageable) {
        return manufacturerRepository.findAllSortName(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortCode(Pageable pageable) {
        return manufacturerRepository.findAllSortCode(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortAddress(Pageable pageable) {
        return manufacturerRepository.findAllSortAddress(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortNote(Pageable pageable) {
        return manufacturerRepository.findAllSortNote(pageable);
    }

    @Override
    public Page<Manufacturer> findAllSortPhoneNumber(Pageable pageable) {
        return manufacturerRepository.findAllSortPhoneNumber(pageable);
    }

    @Override

    public Page<ImportBill> findByIdManufacturer(Long id,Pageable pageable) {

        return importBillRepository.findAllByImportBill(id,pageable);
    }

    @Override
    public ImportBill findByIdImportBill(Long id) {
        return importBillRepository.findByIdImportBill(id);
    }

    @Override
    public Page<ImportBill> findByDateImportBill(Long id,String startDate, String endDate,Pageable pageable) {
        return importBillRepository.findByDateImportBill(id,startDate,endDate,pageable);
    }

    @Override
    public List<Manufacturer> getAll() {
        return  manufacturerRepository.findAll();
    }

    @Override
    public Optional<Manufacturer> findByIdM(Long id) {
        return manufacturerRepository.findById(id);
    }

    public Page<Manufacturer> findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }
}