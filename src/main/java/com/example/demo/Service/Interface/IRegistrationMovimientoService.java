package com.example.demo.Service.Interface;

import com.example.demo.Entity.RegistrationMovimiento;

import java.util.List;

public interface IRegistrationMovimientoService extends IBaseService<RegistrationMovimiento> {
    List<RegistrationMovimiento> findByDateEntry();
    List<RegistrationMovimiento> findByDateOutput();
}
