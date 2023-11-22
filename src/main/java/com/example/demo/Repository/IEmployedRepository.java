package com.example.demo.Repository;

import com.example.demo.DTO.IEmployeeDetails;
import com.example.demo.Entity.Employed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed, Long>{
    @Query("SELECT e FROM Employed e WHERE e.fullName = :fullName")
    Employed findByFullName();

    @Query("SELECT e FROM Employed e WHERE e.position = :puesto")
    Iterable<Employed> findByPosition();

    @Query(value = " SELECT e.fullName AS fullName, es.nameObject AS nameObject, rm.dateEntry AS dateEntry, rm.dateOutput AS dateOutput\n" +
            "\tFROM employed e\n" +
            "    INNER JOIN registrationmovimiento rm  ON e.id = rm.employed_id\n" +
            "    INNER JOIN  elementstaff es ON e.id = es.employed_id\n" +
            "WHERE e.id = :employedId ", nativeQuery = true)
    List<IEmployeeDetails> findEmployeeDetailsById(@Param("employedId") Long employedId);
}
