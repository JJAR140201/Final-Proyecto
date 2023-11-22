package com.example.demo.Service.Interface;

import com.example.demo.Entity.Employed;

import java.util.List;

public interface IEmployedService extends IBaseService<Employed> {
    List<Employed> findByFullName();
    List<Employed> findByPosition();
    List<Employed> findEmployeeDetailsById(Long employedId);
}
