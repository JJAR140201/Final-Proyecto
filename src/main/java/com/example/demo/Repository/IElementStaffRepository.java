package com.example.demo.Repository;

import com.example.demo.Entity.ElementStaff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IElementStaffRepository extends IBaseRepository<ElementStaff, Long>{

    @Query("SELECT e FROM ElementStaff e WHERE e.nameObject = :nameObjeto")
    ElementStaff findByNameObject();

    @Query("SELECT e FROM ElementoPersonal e WHERE e.description = :description")
    List<ElementStaff> findByDescription();

    @Query("SELECT e FROM ElementoPersonal e WHERE e.dateAcquisition = :dateAcquisition")
    List<ElementStaff> findByDateAcquisition();
}
