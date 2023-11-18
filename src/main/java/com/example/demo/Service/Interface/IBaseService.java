package com.example.demo.Service.Interface;

import com.example.demo.Entity.Audit;

import java.util.List;

public interface IBaseService <T extends Audit>{
    List<T> all();
    List<T> findByStateTrue();
    T findById(Long id) throws Exception;
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;
}
