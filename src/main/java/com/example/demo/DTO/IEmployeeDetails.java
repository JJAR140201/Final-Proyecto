package com.example.demo.DTO;

import java.time.LocalDateTime;
import java.util.List;

public interface IEmployeeDetails {
    String getFullName();
    String getNameObject();
    List<LocalDateTime> getDateEntry();
    List<LocalDateTime> getDateOutput();
}
