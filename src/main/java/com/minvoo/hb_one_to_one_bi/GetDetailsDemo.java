package com.minvoo.hb_one_to_one_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetDetailsDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            InstructorDetail instructorDetail = session.get(InstructorDetail.class, 1L);
            System.out.println(instructorDetail);

            System.out.println(instructorDetail.getInstructor());

            System.out.println(instructorDetail.getInstructor().getInstructorDetail()); // just to check xD


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
