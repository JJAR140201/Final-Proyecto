package com.example.demo.Controller;

import com.example.demo.Entity.ElementStaff;
import com.example.demo.Entity.Employed;
import com.example.demo.Service.Interface.IElementStaffService;
import com.example.demo.Service.Interface.IEmployedService;
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

    protected EmployedController(IEmployedService service, String entityName) {
        super(service, entityName);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employed> getEmployedById(@PathVariable Long id) throws Exception {
        Optional<Employed> employed = Optional.ofNullable(employedService.findById(id));
        return employed.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
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

    @PostMapping
    public ResponseEntity<Employed> createEmployed(@RequestBody Employed employed) {
        try {
            Employed createdEmployed = employedService.save(employed);
            return new ResponseEntity<>(createdEmployed, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employed> updateEmployed(@PathVariable Long id, @RequestBody Employed employed) {
        try {
            employedService.update(id, employed);
            return new ResponseEntity<>(employed, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployed(@PathVariable Long id) {
        try {
            employedService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
