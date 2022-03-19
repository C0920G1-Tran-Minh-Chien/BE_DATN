
package com.backend.pharmacy_management.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneralService<T> {
    Page<T> findAllWithKeyWord(Pageable pageable, String keyword);

    Optional<T> findById(Long id);

    List<T> findAllNormal();

    void save(T t);

    void remove(Long id);

}
