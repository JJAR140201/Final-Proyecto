package com.example.demo.Repository;

import com.example.demo.Entity.Employed;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployedRepository extends IBaseRepository<Employed, Long>{
    @Query("SELECT e FROM Employed e WHERE e.fullName = :fullName")
    Employed findByFullName();

    @Query("SELECT e FROM Employed e WHERE e.position = :puesto")
    Iterable<Employed> findByPosition();
}
