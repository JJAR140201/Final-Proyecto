package com.example.demo.Service;

import com.example.demo.Entity.ElementStaff;
import com.example.demo.Repository.IBaseRepository;
import com.example.demo.Repository.IElementStaffRepository;
import com.example.demo.Service.Interface.IElementStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class ElementStaffService extends BaseService<ElementStaff> implements IElementStaffService {

    @Autowired
    private IElementStaffRepository repository;

    @Override
    protected IBaseRepository<ElementStaff, Long> getRepository() {
        return repository;
    }

    @Override
    public List<ElementStaff> findByNameObject(String nameObjeto) {
        return Collections.singletonList(repository.findByNameObject(nameObjeto));
    }

    @Override
    public List<ElementStaff> findByDescription(String description) {
        return repository.findByDescription(description);
    }

    @Override
    public List<ElementStaff> findByDateAcquisition(Date dateAcquisition) {
        return repository.findByDateAcquisition(dateAcquisition);
    }
}
