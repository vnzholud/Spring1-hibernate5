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
//          проверка
            ProductDao productDao = new ProductDao(factory);
            Product p = productDao.findById(2L);
            System.out.println(p);
            List<Product> products = productDao.findAll();
            System.out.println(products);
            Product product = new Product();
            product.setTitle("rrrr");
            product.setPrice(90);
            Product p1 = productDao.saveOrUpdate(product);
            System.out.println(p1);

            productDao.delete(6L);
            System.out.println(productDao.findAll());

            Product product1 = productDao.findById(1L);
            productDao.delete(product1);
            System.out.println(productDao.findAll());


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
