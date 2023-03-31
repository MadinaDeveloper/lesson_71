package com.example.repository;

import com.example.entity.StudentBookEntity;
import com.example.entity.StudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentBookRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public StudentBookEntity save(StudentBookEntity entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
        return entity;
    }


}
