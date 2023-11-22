package com.example.demo.Repository;

import com.example.demo.DTO.IEmployeeDetails;
import com.example.demo.Entity.Employed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed, Long>{
    @Query("SELECT e FROM Employed e WHERE e.fullName = :fullName")
    Employed findByFullName();

    @Query("SELECT e FROM Employed e WHERE e.position = :puesto")
    Iterable<Employed> findByPosition();

    @Query("SELECT e.fullName AS fullName, es.nameObject AS nameObject, rm.dateEntry AS dateEntry, rm.dateOutput AS dateOutput " +
            "FROM Employed e " +
            "LEFT JOIN e.registrationMovimientos rm " +
            "LEFT JOIN e.elementStaff es " +
            "WHERE e.id = :employedId")
    IEmployeeDetails findEmployeeDetailsById(@Param("employedId") Long employed_id);
}
