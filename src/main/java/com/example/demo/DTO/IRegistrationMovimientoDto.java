package com.example.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IRegistrationMovimientoDto {
    Long getId();
    List<LocalDateTime> getDateEntry();
    List<LocalDateTime> getDateOutput();
}
