package com.example.demo.Service;

import com.example.demo.DTO.IEmployeeDetails;
import com.example.demo.Entity.Employed;
import com.example.demo.Repository.IBaseRepository;
import com.example.demo.Repository.IEmployedRepository;
import com.example.demo.Service.Interface.IEmployedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeService extends BaseService<Employed> implements IEmployedService {

    @Autowired
    private IEmployedRepository repository;
    @Override
    protected IBaseRepository<Employed, Long> getRepository() {
        return repository;
    }

    @Override
    public List<Employed> findByFullName() {
        return Collections.singletonList(repository.findByFullName());
    }

    @Override
    public List<Employed> findByPosition() {
        return (List<Employed>) repository.findByPosition();
    }

    @Override
    public IEmployeeDetails findEmployeeDetailsById(Long employedId){return repository.findEmployeeDetailsById(employedId);}
}
