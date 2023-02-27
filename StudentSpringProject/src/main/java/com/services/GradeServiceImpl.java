package com.services;

import com.model.Grade;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GradeServiceImpl implements GradeService{
    @Autowired
    private SessionFactory sessionFactory;
    public List<Grade> getGrade() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Grade> GradeList= session.createQuery("from Grade",Grade.class).list();
        transaction.commit();
        session.close();
        return GradeList;
    }
}
