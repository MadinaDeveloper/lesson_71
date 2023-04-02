package com.example.service;

import com.example.dto.StudentDTO;
import com.example.entity.StudentEntity;
import com.example.exp.AppBadRequestException;
import com.example.repository.StudentRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SessionFactory sessionFactory;

    public StudentDTO crate(StudentDTO dto) {
        StudentEntity entity = new StudentEntity();
        entity.setName(dto.getName());
        entity.setSurname(dto.getSurname());
        if (dto.getName() == null || dto.getName().isBlank()) {
            throw new AppBadRequestException("Name qani?");
        }
        if (dto.getSurname() == null || dto.getSurname().isBlank()) {
            throw new AppBadRequestException("Surname qani?");
        }
        studentRepository.saveStudent(entity);
        dto.setId(entity.getId());
        return dto;
    }
// important todo
    public  boolean delete(Integer id){
        StudentEntity entity =get(id);
        studentRepository.delete(entity);
        return true;
    }
    public StudentEntity get(Integer id) {
        Session session = sessionFactory.openSession();
        StudentEntity entity = session.find(StudentEntity.class, id);
        session.close();
        return entity;
    }
}
