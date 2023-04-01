package com.example.controller;

import com.example.dto.BookDTO;
import com.example.dto.StudentDTO;
import com.example.exp.AppBadRequestException;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
public class BookController {
    @Autowired
    private BookService bookService;

    private List<BookDTO> bookDTOList = new LinkedList<>();

    public BookController() {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(1);
        bookDTO.setTitle("Java");
        bookDTO.setAuthor("Alisher");

        bookDTOList.add(bookDTO);
    }

    @GetMapping("/list")
    public List<BookDTO> getAll() {
        return bookDTOList;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<BookDTO> optional = bookDTOList.stream().filter(bookDTO -> bookDTO.getId().equals(id)).findAny();
        if (optional.isEmpty()) {
            return ResponseEntity.badRequest().body("Book Not Found");
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody BookDTO bookDTO) {
        try {
            BookDTO response = bookService.create(bookDTO);
            return ResponseEntity.ok(response);
        } catch (AppBadRequestException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody BookDTO bookDTO) {
        for (BookDTO dto : bookDTOList) {
            if (dto.getId().equals(id)) {
                dto.setTitle(bookDTO.getTitle());
                dto.setAuthor(bookDTO.getAuthor());
                return true;
            }
        }
        return false;
    }
}
