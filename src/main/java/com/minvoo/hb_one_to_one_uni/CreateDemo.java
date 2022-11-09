package com.minvoo.hb_one_to_one_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();
            System.out.println("Creating new Instructor objects");

            Instructor instructor = new Instructor("John", "Doe", "john@doe.com");
            Instructor instructor2 = new Instructor("John", "Jane", "mary@jane.com");
            Instructor instructor3 = new Instructor("Test", "Test", "test", new InstructorDetail("12313", "1231"));

            System.out.println("Creating new InstructrorDetails objects");
            InstructorDetail instructorDetail = new InstructorDetail("https://youtube.com", "hobby1");
            InstructorDetail instructorDetail2 = new InstructorDetail("https://youtube.com", "hobby2");

            instructor.setInstructorDetail(instructorDetail);
            instructor2.setInstructorDetail(instructorDetail2);


            System.out.println("Saving instructor " + instructor);
            session.save(instructor);
            System.out.println("Saving instructor2 " + instructor2);
            session.save(instructor2);
            System.out.println("Saving instructor3 " + instructor3);
            session.save(instructor3);
            //InstructorDetail persists in the database because CascadeType.ALL

            transaction.commit();

            // we have access to InstructorDetail fields becasue Instructor owns the relationship.
            String hobby = instructor.getInstructorDetail().getHobby();

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
