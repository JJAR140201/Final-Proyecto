package com.example.demo.Service.Interface;

import com.example.demo.Entity.RegistrationMovimiento;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface IRegistrationMovimientoService extends IBaseService<RegistrationMovimiento> {

    List<RegistrationMovimiento> findByDateEntry(LocalDateTime dateEntry);

    List<RegistrationMovimiento> findByDateOutput(LocalDateTime dateOutput);
}
