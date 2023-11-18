package com.example.demo.DTO;

import java.time.LocalDateTime;

public interface IElementStaffDto {
    Long getId();
    String getNameObject();
    String getDescription();
    LocalDateTime getDateAcquisition();
}
