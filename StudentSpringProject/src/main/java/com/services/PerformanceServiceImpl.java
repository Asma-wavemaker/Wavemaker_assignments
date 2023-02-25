package com.services;

import com.model.Performance;
import com.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PerformanceServiceImpl implements PerformanceService{
    @Autowired
    private SessionFactory sessionFactory;
    public List<Performance> getPerformance() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Performance> PerformanceList= session.createQuery("from Performance",Performance.class).list();
        transaction.commit();
        session.close();
        return PerformanceList;
    }
    public Performance create(Performance performance){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(performance);
        transaction.commit();
        session.close();
        return performance;
    }
    public Performance getPerformanceById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Performance performance = session.get(Performance.class,id);
        transaction.commit();
        session.close();
        return performance;
    }

    public Performance updatePerformance(Performance performance){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(performance);
        transaction.commit();
        session.close();
        return performance;
    }

    public Performance deletePerformanceById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Performance performance = session.get(Performance.class,id);
        session.delete(performance);
        transaction.commit();
        session.close();
        return performance;
    }
}
