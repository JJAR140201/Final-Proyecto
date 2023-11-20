package com.example.demo.Repository;

import com.example.demo.Entity.RegistrationMovimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IRegistrationMovimientoRepository extends IBaseRepository<RegistrationMovimiento, Long> {
    @Query("SELECT r FROM RegistroMovimiento r WHERE r.dateEntry = :dateEntry")
    List<RegistrationMovimiento> findByDateEntry(@Param("dateEntry") Date dateEntry);

    @Query("SELECT r FROM RegistroMovimiento r WHERE r.dateOutput = :dateOutput")
    List<RegistrationMovimiento> findByDateOutput(@Param("dateOutput") Date dateOutput);
}
