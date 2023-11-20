package com.example.demo.Controller;

import com.example.demo.Entity.ElementStaff;
import com.example.demo.Service.Interface.IElementStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/elementstaff")
public class ElementStaffController extends BaseController<ElementStaff,IElementStaffService> {
    @Autowired
    private IElementStaffService elementStaffService;

    protected ElementStaffController(IElementStaffService service, String entityName) {
        super(service, entityName);
    }

    @GetMapping
    public ResponseEntity<List<ElementStaff>> getAllElementStaff() {
        List<ElementStaff> elementStaffList = elementStaffService.all();
        return new ResponseEntity<>(elementStaffList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ElementStaff> getElementStaffById(@PathVariable Long id) throws Exception {
        Optional<ElementStaff> elementStaff = Optional.ofNullable(elementStaffService.findById(id));
        return elementStaff.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByNameObject")
    public ResponseEntity<List<ElementStaff>> getElementStaffByNameObject() {
        List<ElementStaff> elementStaffList = elementStaffService.findByNameObject();
        return new ResponseEntity<>(elementStaffList, HttpStatus.OK);
    }

    @GetMapping("/findByDescription")
    public ResponseEntity<List<List<ElementStaff>>> getElementStaffByDescription() {
        List<List<ElementStaff>> elementStaffList = elementStaffService.findByDescription();
        return new ResponseEntity<>(elementStaffList, HttpStatus.OK);
    }

    @GetMapping("/findByDateAcquisition")
    public ResponseEntity<List<ElementStaff>> getElementStaffByDateAcquisition() {
        List<ElementStaff> elementStaffList = elementStaffService.findByDateAcquisition();
        return new ResponseEntity<>(elementStaffList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ElementStaff> createElementStaff(@RequestBody ElementStaff elementStaff) {
        try {
            ElementStaff createdElementStaff = elementStaffService.save(elementStaff);
            return new ResponseEntity<>(createdElementStaff, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ElementStaff> updateElementStaff(@PathVariable Long id, @RequestBody ElementStaff elementStaff) {
        try {
            elementStaffService.update(id, elementStaff);
            return new ResponseEntity<>(elementStaff, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteElementStaff(@PathVariable Long id) {
        try {
            elementStaffService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}