package com.minvoo.hb_many_to_many;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCoursesAndStudentsDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Student student = new Student("John", "Doe", "john@doe.com");
            Student student1 = new Student("Mary", "Jane", "ilove@peterparker.com");

            Course hibernate_orm = new Course("Hibernate ORM");
            Course hibernateCourse = new Course("hibernate_orm");

            hibernateCourse.addReview(new Review("excellent"));
            hibernateCourse.addReview(new Review("excellent2"));
            hibernate_orm.addReview(new Review("bad"));
            hibernate_orm.addReview(new Review("buuu"));

            hibernateCourse.addStudent(student);
            hibernateCourse.addStudent(student1);

            hibernate_orm.addStudent(student);
            hibernate_orm.addStudent(student1);
            session.save(hibernateCourse);
            session.save(hibernate_orm);
            session.save(student1);
            session.save(student);

            transaction.commit();


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
