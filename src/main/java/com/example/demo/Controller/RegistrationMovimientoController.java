package com.example.demo.Controller;

import com.example.demo.Entity.Employed;
import com.example.demo.Entity.RegistrationMovimiento;
import com.example.demo.Service.Interface.IEmployedService;
import com.example.demo.Service.Interface.IRegistrationMovimientoService;
import com.example.demo.Service.RegistrationMovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/registrationmovimientos")
@CrossOrigin("*")
public class RegistrationMovimientoController {
    @Autowired
    private IRegistrationMovimientoService registrationMovimientoService;

    @GetMapping("/getAllRegistrationMovimientos")
    public ResponseEntity<List<RegistrationMovimiento>> getAllRegistrationMovimientos() {
        List<RegistrationMovimiento> registrationMovimientoList = registrationMovimientoService.all();
        return new ResponseEntity<>(registrationMovimientoList, HttpStatus.OK);
    }

    @GetMapping("/getRegistrationMovimientoById/{id}")
    public ResponseEntity<RegistrationMovimiento> getRegistrationMovimientoById(@PathVariable Long id) throws Exception {
        Optional<RegistrationMovimiento> registrationMovimiento = Optional.ofNullable(registrationMovimientoService.findById(id));
        return registrationMovimiento.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByDateEntry")
    public ResponseEntity<List<RegistrationMovimiento>> getRegistrationMovimientosByDateEntry(@RequestParam(name = "dateEntry") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateEntry) {
        List<RegistrationMovimiento> registrationMovimientoList = registrationMovimientoService.findByDateEntry(dateEntry);
        return new ResponseEntity<>(registrationMovimientoList, HttpStatus.OK);
    }

    @GetMapping("/findByDateOutput")
    public ResponseEntity<List<RegistrationMovimiento>> getRegistrationMovimientosByDateOutput(@RequestParam(name = "dateOutput") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateOutput) {
        List<RegistrationMovimiento> registrationMovimientoList = registrationMovimientoService.findByDateOutput(dateOutput);
        return new ResponseEntity<>(registrationMovimientoList, HttpStatus.OK);
    }

    @PostMapping("/createRegistrationMovimiento")
    public ResponseEntity<RegistrationMovimiento> createRegistrationMovimiento(@RequestBody RegistrationMovimiento registrationMovimiento) {
        try {
            RegistrationMovimiento createdRegistrationMovimiento = registrationMovimientoService.save(registrationMovimiento);
            return new ResponseEntity<>(createdRegistrationMovimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateRegistrationMovimiento/{id}")
    public ResponseEntity<RegistrationMovimiento> updateRegistrationMovimiento(@PathVariable Long id, @RequestBody RegistrationMovimiento registrationMovimiento) {
        try {
            registrationMovimientoService.update(id, registrationMovimiento);
            return new ResponseEntity<>(registrationMovimiento, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteRegistrationMovimiento/{id}")
    public ResponseEntity<Void> deleteRegistrationMovimiento(@PathVariable Long id) {
        try {
            registrationMovimientoService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
