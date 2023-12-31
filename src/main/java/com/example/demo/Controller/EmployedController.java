package com.example.demo.Controller;

import com.example.demo.DTO.IEmployeeDetails;
import com.example.demo.Entity.ElementStaff;
import com.example.demo.Entity.Employed;
import com.example.demo.Service.Interface.IEmployedService;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/employed")
public class EmployedController extends BaseController<Employed, IEmployedService> {
    @Autowired
    private IEmployedService employedService;

    @Autowired
    public EmployedController(IEmployedService employedService) {
        super(employedService, "Employed");
        this.employedService = employedService;
    }

    @GetMapping("/getEmployedById/{id}")
    public ResponseEntity<Employed> getEmployedById(@PathVariable Long id) throws Exception {
        Optional<Employed> employed = Optional.ofNullable(employedService.findById(id));
        return employed.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/allEmployed")
    public ResponseEntity<List<Employed>> getAllElementStaff() {
        List<Employed> employedList = employedService.all();
        return new ResponseEntity<>(employedList, HttpStatus.OK);
    }

    @GetMapping("/findByFullName")
    public ResponseEntity<List<Employed>> getEmployedByFullName() {
        List<Employed> employedList = employedService.findByFullName();
        return new ResponseEntity<>(employedList, HttpStatus.OK);
    }

    @GetMapping("/findByPosition")
    public ResponseEntity<List<Employed>> getEmployedByPosition() {
        List<Employed> employedList = employedService.findByPosition();
        return new ResponseEntity<>(employedList, HttpStatus.OK);
    }

    @GetMapping("/findEmployeeDetailsById/{employedId}")
    public ResponseEntity<List<IEmployeeDetails>> findEmployeeDetailsById(@PathVariable Long employedId) {
        List<IEmployeeDetails> employeeDetails = (List<IEmployeeDetails>) employedService.findEmployeeDetailsById(employedId);
        return new ResponseEntity<>(employeeDetails, HttpStatus.OK);
    }



    @PostMapping("/createEmployed")
    public ResponseEntity<Employed> createEmployed(@RequestBody Employed employed) {
        try {
            Employed createdEmployed = employedService.save(employed);
            return new ResponseEntity<>(createdEmployed, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEmployed/{id}")
    public ResponseEntity<Employed> updateEmployed(@PathVariable Long id, @RequestBody Employed employed) {
        try {
            employedService.update(id, employed);
            return new ResponseEntity<>(employed, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEmployed/{id}")
    public ResponseEntity<Void> deleteEmployed(@PathVariable Long id) {
        try {
            employedService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
