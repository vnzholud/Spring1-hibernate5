package ru.zholud.homeworke5.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class MainApp {
    private static SessionFactory factory;

    public static void init() {
        PrepareDataApp.forcePrepareData();
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void main(String[] args) {
        try {
            init();
            Session session = null;
            System.out.println("***********************************");
//          проверка
            session = factory.getCurrentSession();

            session.beginTransaction();

            User user = session.get(User.class, 1L);
            System.out.println(user);
            System.out.println(user.getProduct());
            System.out.println("***********************************");




        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }



    public static void shutdown() {
        factory.close();
    }
}
