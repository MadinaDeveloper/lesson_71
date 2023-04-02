package com.example.controller;

import com.example.dto.StudentDTO;
import com.example.exp.AppBadRequestException;
import com.example.exp.PhoneAlreadyExistExeption;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    private List<StudentDTO> studentList = new LinkedList<>();



    @GetMapping("/list")
    public List<StudentDTO> getAll() {
        return studentList;
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        Optional<StudentDTO> optional = studentList.stream().filter(studentDTO -> studentDTO.getId().equals(id)).findAny();
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody StudentDTO studentDTO) {
//         studentService.crate(studentDTO);
//        return new ResponseEntity<>("test message", HttpStatus.OK);
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

//        StudentDTO response = studentService.crate(studentDTO);
//        return new ResponseEntity<>(response, HttpStatus.OK);

//        StudentDTO response = studentService.crate(studentDTO);
//        return ResponseEntity.ok(response);

//        StudentDTO response = studentService.crate(studentDTO);
//        return ResponseEntity.ok().body(response);

//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        return ResponseEntity.badRequest().build();
            StudentDTO response = studentService.crate(studentDTO);
            return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/create/all")
    public Boolean createAll(@RequestBody List<StudentDTO> list) {
        for (StudentDTO dto : list) {
            dto.setId(1);
            studentList.add(dto);
        }
        return true;
    }

    @PutMapping(value = "/update/{id}")
    public Boolean update(@PathVariable("id") String id, @RequestBody StudentDTO studentDTO) {
        for (StudentDTO dto : studentList) {
            if (dto.getId().equals(id)) {
                dto.setName(studentDTO.getName());
                dto.setSurname(studentDTO.getSurname());
                return true;
            }
        }
        return false;
    }

    @DeleteMapping(value = "/delete/{id}")
    public Boolean delete(@PathVariable("id") String id) {
        return studentList.removeIf(studentDTO -> studentDTO.getId().equals(id));
    }


}
