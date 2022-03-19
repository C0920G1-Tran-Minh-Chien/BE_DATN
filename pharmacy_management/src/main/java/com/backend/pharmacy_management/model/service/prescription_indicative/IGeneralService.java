package com.backend.pharmacy_management.model.service.prescription_indicative;
public interface IGeneralService<T> {
    Iterable<T> findAll();

    T findById(Long id);

    T save(T t);

    void remove(Long id);



}