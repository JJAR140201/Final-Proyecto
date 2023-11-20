package com.example.demo.Repository;

import com.example.demo.Entity.ElementStaff;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IElementStaffRepository extends IBaseRepository<ElementStaff, Long>{

    @Query("SELECT e FROM ElementStaff e WHERE e.nameObject = :nameObjeto")
    ElementStaff findByNameObject(@Param("nameObjeto") String nameObjeto);


    @Query("SELECT e FROM ElementStaff e WHERE e.description = :description")
    List<ElementStaff> findByDescription(@Param("description") String description);

    @Query("SELECT e FROM ElementStaff e WHERE e.dateAcquisition = :dateAcquisition")
    List<ElementStaff> findByDateAcquisition(@Param("dateAcquisition") Date dateAcquisition);

}
