package com.minvoo.hb_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1L);

            System.out.println("Getting instructor before delete course attempt and commit transaction");
            System.out.println(instructor.getCourses());
            Course course = session.get(Course.class, 2L);

            session.delete(course);

            System.out.println("Getting instructor after delete course attempt and before commit transaction");
            Instructor instructor1 = session.get(Instructor.class, 1L);
            System.out.println(instructor1.getCourses());
            transaction.commit();
            Session session1 = sessionFactory.openSession();
            System.out.println("Getting instructor after delete course attempt and after commit transaction");
            Instructor instructor2 = session1.get(Instructor.class, 1L);
            System.out.println(instructor2.getCourses());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
