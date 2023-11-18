package com.example.demo.Service;

import com.example.demo.Entity.RegistrationMovimiento;
import com.example.demo.Repository.IBaseRepository;
import com.example.demo.Repository.IRegistrationMovimientoRepository;
import com.example.demo.Service.Interface.IBaseService;
import com.example.demo.Service.Interface.IElementStaffService;
import com.example.demo.Service.Interface.IRegistrationMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationMovimientoService extends BaseService<RegistrationMovimiento> implements IRegistrationMovimientoService {

    @Autowired
    private IRegistrationMovimientoRepository repository;

    @Override
    protected IBaseRepository<RegistrationMovimiento, Long> getRepository() {
        return repository;
    }

    @Override
    public List<RegistrationMovimiento> findByDateEntry() {
        return repository.findByDateEntry();
    }

    @Override
    public List<RegistrationMovimiento> findByDateOutput() {
        return repository.findByDateOutput();
    }
}
