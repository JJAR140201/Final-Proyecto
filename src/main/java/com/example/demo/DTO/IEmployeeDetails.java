package com.example.demo.DTO;

import java.time.LocalDateTime;

public interface IEmployeeDetails {
    String getFullName();
    String getNameObject();
    LocalDateTime getDateEntry();
    LocalDateTime getDateOutput();
}
