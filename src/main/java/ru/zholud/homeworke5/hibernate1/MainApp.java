package ru.zholud.homeworke5.hibernate1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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
            readAndPrintExample();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.openSession()) {
            SimpleItem simpleItem = session.get(SimpleItem.class, 3L);
            System.out.println(session.getTransaction().isActive());
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            SimpleItem simpleItem = session.get(SimpleItem.class, 3L);
            System.out.println(simpleItem);
            session.getTransaction().commit();
        }
    }

    public static void shutdown() {
        factory.close();
    }
}
