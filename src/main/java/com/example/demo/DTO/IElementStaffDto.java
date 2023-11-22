package com.example.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IElementStaffDto {
    Long getId();
    String getNameObject();
    String getDescription();
    List<LocalDateTime> getDateAcquisition();
}
