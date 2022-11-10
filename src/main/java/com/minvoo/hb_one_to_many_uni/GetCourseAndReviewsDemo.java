package com.minvoo.hb_one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class GetCourseAndReviewsDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Course course = session.get(Course.class, 1L);

            transaction.commit();

            List<Review> reviews = course.getReviews();
            System.out.println(reviews);

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
