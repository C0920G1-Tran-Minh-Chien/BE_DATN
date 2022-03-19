package com.backend.pharmacy_management.model.service.cart;

import com.backend.pharmacy_management.model.entity.voucher.Voucher;
import com.backend.pharmacy_management.model.repository.IVoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoucherService implements IVoucherService{
    @Autowired
    IVoucherRepository iVoucherRepository;

    @Override
    public List<Voucher> findAll() {
        return iVoucherRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        iVoucherRepository.deleteById(id);
    }

    @Override
    public Optional<Voucher> findById(Long id) {
        return iVoucherRepository.findById(id);
    }
}
