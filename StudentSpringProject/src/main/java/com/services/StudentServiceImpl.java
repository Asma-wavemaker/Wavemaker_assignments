package com.services;

import org.hibernate.Session;
import com.model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private SessionFactory sessionFactory;
    public List<Student> getStudents() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> StudentList= session.createQuery("from Student",Student.class).list();
        transaction.commit();
        session.close();
        return StudentList;
    }
    public Student create(Student stu){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(stu);
        transaction.commit();
        session.close();
        return stu;
    }
    public Student getStudentById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student stu = session.get(Student.class,id);
        transaction.commit();
        session.close();
        return stu;
    }

    public Student updateStudent(Student stu){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(stu);
        transaction.commit();
        session.close();
        return stu;
    }

    public Student deleteStudentById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class,id);
        session.delete(student);
        transaction.commit();
        session.close();
        return student;
    }
}
