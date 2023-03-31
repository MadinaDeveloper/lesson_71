package com.example.repository;

import com.example.entity.BookEntity;
import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public BookEntity get(Integer id) {
        Session session = sessionFactory.openSession();
        BookEntity entity = session.find(BookEntity.class, id);
        session.close();
        return entity;
    }
}
