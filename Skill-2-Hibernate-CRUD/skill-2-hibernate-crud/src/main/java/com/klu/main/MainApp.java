package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Product;

public class MainApp {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        try {

            // INSERT PRODUCTS
            session.beginTransaction();

            Product p1 = new Product("Laptop","Dell Inspiron",65000,5);
            Product p2 = new Product("Phone","Samsung Galaxy",30000,10);
            Product p3 = new Product("Headphones","Sony Wireless",5000,15);

            session.persist(p1);
            session.persist(p2);
            session.persist(p3);

            session.getTransaction().commit();

            System.out.println("Products inserted successfully");


            // getting product
            session = factory.openSession();
            session.beginTransaction();

            Product product = session.get(Product.class, 1);

            System.out.println("Retrieved Product: " + product.getName());

            session.getTransaction().commit();


            // update operation
            session = factory.openSession();
            session.beginTransaction();

            Product updateProduct = session.get(Product.class, 2);
            updateProduct.setPrice(28000);

            session.getTransaction().commit();

            System.out.println("Product updated successfully");


            // delete operation
            session = factory.openSession();
            session.beginTransaction();

            Product deleteProduct = session.get(Product.class, 3);
            session.remove(deleteProduct);

            session.getTransaction().commit();

            System.out.println("Product deleted successfully");


        } finally {
            session.close();
            factory.close();
        }
    }
}