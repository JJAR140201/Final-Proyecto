package com.example.demo.Service.Interface;

import com.example.demo.Entity.ElementStaff;

import java.util.List;

public interface IElementStaffService extends IBaseService<ElementStaff>{
    List<ElementStaff> findByNameObject();
    List<ElementStaff> findByDescription();
    List<ElementStaff> findByDateAcquisition();
}
