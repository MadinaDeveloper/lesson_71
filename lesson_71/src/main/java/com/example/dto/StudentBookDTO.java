package com.example.dto;

import com.example.enums.StudentBookStatus;
import com.example.service.StudentBookService;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentBookDTO {
    private Integer id;
    private Integer studentId;
    private Integer bookId;

    private LocalDateTime createdDate;
    private StudentBookStatus status;
}
