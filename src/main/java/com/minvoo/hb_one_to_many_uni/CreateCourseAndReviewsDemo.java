package com.minvoo.hb_one_to_many_uni;

import com.minvoo.hb_one_to_many_uni.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CreateCourseAndReviewsDemo {

    public static void main(String[] args) {


        SessionFactory sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        try {

            Transaction transaction = session.beginTransaction();

            Course hibernate_basics = new Course("hibernate basics");
            Review review1 = new Review("Fantastic course");
            Review review2 = new Review("What a piece of $hit");

            hibernate_basics.addReview(review1);
            hibernate_basics.addReview(review2);

            session.save(hibernate_basics); //it also saves the reviews, because of cascadeType.ALL
            System.out.println(hibernate_basics);
            transaction.commit();

            List<Review> reviews = hibernate_basics.getReviews();
            System.out.println(reviews);


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
