package com.example.demo.Service.Interface;

import com.example.demo.Entity.ElementStaff;

import java.util.Date;
import java.util.List;

public interface IElementStaffService extends IBaseService<ElementStaff>{
    List<ElementStaff> findByNameObject(String nameObjeto);

    List<ElementStaff> findByDescription(String description);

    List<ElementStaff> findByDateAcquisition(Date dateAcquisition);
}
