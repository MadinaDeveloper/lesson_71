package com.example.controller;

import com.example.dto.StudentBookDTO;
import com.example.service.StudentBookService;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/student-book")
public class StudentBookController {
    @Autowired
    private StudentBookService studentBookService;

    @PostMapping(value = "/take")
    public StudentBookDTO create(@RequestBody StudentBookDTO studentBookDTO) {
        return studentBookService.takeBook(studentBookDTO);
    }
}
