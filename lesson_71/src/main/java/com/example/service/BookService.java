package com.example.service;

import com.example.dto.BookDTO;
import com.example.dto.StudentDTO;
import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookDTO create(BookDTO dto) {
        BookEntity entity = new BookEntity();
        entity.setTitle(dto.getTitle());
        entity.setAuthor(dto.getAuthor());
        if (dto.getTitle() == null || dto.getTitle().isBlank()) {
            throw new AppBadRequestException("Where is  title?");
        }
        if (dto.getAuthor() == null || dto.getAuthor().isBlank()) {
            throw new AppBadRequestException("Where is Author?");
        }

        entity.setTitle(entity.getTitle());
        entity.setAuthor(entity.getAuthor());
        entity.setPublishYear(LocalDate.now());

        bookRepository.saveBook(entity);
        dto.setId(entity.getId());
        return dto;
    }
}

