package com.backend.pharmacy_management.model.service.cart;

import com.backend.pharmacy_management.model.entity.voucher.Voucher;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IVoucherService {
    List<Voucher> findAll();
    void remove(Long id);
    Optional<Voucher> findById(Long id);
}
