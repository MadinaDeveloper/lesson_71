package com.example.service;

import com.example.dto.StudentBookDTO;
import com.example.entity.BookEntity;
import com.example.entity.StudentBookEntity;
import com.example.entity.StudentEntity;
import com.example.enums.StudentBookStatus;
import com.example.repository.BookRepository;
import com.example.repository.StudentBookRepository;
import com.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentBookService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private StudentBookRepository studentBookRepository;

    public StudentBookDTO takeBook(StudentBookDTO dto) {
        // check student
        StudentEntity studentEntity = studentRepository.get(dto.getStudentId());
        if (studentEntity == null) {
            return null;
        }
        // check book
        BookEntity bookEntity = bookRepository.get(dto.getBookId());
        if (bookEntity == null) {
            return null;
        }

        StudentBookEntity entity = new StudentBookEntity();
        entity.setBook(bookEntity);
        entity.setStudent(studentEntity);
        entity.setCreatedDate(LocalDateTime.now());
        entity.setStatus(StudentBookStatus.TAKEN);
        studentBookRepository.save(entity);

        dto.setId(entity.getId());
        dto.setStatus(entity.getStatus());
        dto.setCreatedDate(entity.getCreatedDate());
        return dto;
    }
}
