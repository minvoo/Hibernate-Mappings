package com.minvoo.hb_one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDemo {


    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 2L);
            System.out.println(instructor);
            System.out.println(instructor.getInstructorDetail());

            session.delete(instructor);

            //InstructorDetail also deleted because of CascadeType.ALL !


            transaction.commit();

        } finally {
            sessionFactory.close();
        }
    }
}

