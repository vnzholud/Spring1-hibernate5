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
//            readAndPrintExample();
            ProductDao productDao = new ProductDao(factory);
//            Product p = productDao.findById(2L);
//            System.out.println(p);
            List<Product> products = productDao.findAll();
            System.out.println(products);



        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }

    public static void readAndPrintExample() {
        try (Session session = factory.openSession()) {
            Product product = session.get(Product.class, 3L);
            System.out.println(session.getTransaction().isActive());
        }

        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 3L);
            System.out.println(product);
            session.getTransaction().commit();
        }
    }

    public static void shutdown() {
        factory.close();
    }
}
