package com.example.demo.Service.Interface;

import com.example.demo.Entity.RegistrationMovimiento;

import java.util.Date;
import java.util.List;

public interface IRegistrationMovimientoService extends IBaseService<RegistrationMovimiento> {

    List<RegistrationMovimiento> findByDateEntry(Date dateEntry);

    List<RegistrationMovimiento> findByDateOutput(Date dateOutput);
}
