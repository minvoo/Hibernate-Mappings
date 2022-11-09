package com.minvoo.hb_one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class AddInstructorDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Instructor instructor = new Instructor("John", "Doe", "john@doe.com",
                    new InstructorDetail("youtube", "volley"));

            Course java_basics = new Course("Java basics");
            Course hibernate_orm = new Course("Hibernate ORM");

            instructor.addCourse(java_basics);
            instructor.addCourse(hibernate_orm);

            session.save(instructor);
            session.save(java_basics);
            session.save(hibernate_orm);
            transaction.commit();

            Instructor instructor1 = session.get(Instructor.class, 2L);
            System.out.printf(instructor1.getCourses()+"\n");
            Course course = session.get(Course.class, 1L);
            System.out.println(course.getInstructor());


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
