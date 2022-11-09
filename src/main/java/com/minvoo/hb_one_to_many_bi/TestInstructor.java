package com.minvoo.hb_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestInstructor {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Instructor instructor1 = session.get(Instructor.class, 1L);
            System.out.printf(instructor1.getCourses()+"\n");
            Course course = session.get(Course.class, 1L);
            System.out.println(course.getInstructor());


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
