package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

import com.klu.entity.Product;

public class MainApp {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = factory.openSession();

        // insert operation
        session.beginTransaction();

        Product p1 = new Product("Laptop", "Dell Inspiron", 65000, 5);
        Product p2 = new Product("Phone", "Samsung Galaxy", 30000, 10);
        Product p3 = new Product("Headphones", "Sony Wireless", 5000, 15);

        session.persist(p1);
        session.persist(p2);
        session.persist(p3);

        session.getTransaction().commit();

        System.out.println("Products inserted successfully");


        // get operation
        session = factory.openSession();
        session.beginTransaction();

        Query<Product> query = session.createQuery("FROM Product", Product.class);
        List<Product> products = query.getResultList();

        System.out.println("\nAll Products:");
        for(Product p : products) {
            System.out.println(p.getId() + " " + p.getName() + " " + p.getPrice());
        }

        session.getTransaction().commit();


        // query
        session = factory.openSession();
        session.beginTransaction();

        Query<Product> query2 =
                session.createQuery("FROM Product WHERE price > 20000", Product.class);

        List<Product> expensiveProducts = query2.getResultList();

        System.out.println("\nProducts with price > 20000:");
        for(Product p : expensiveProducts) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        session.getTransaction().commit();


        // update operation
        session = factory.openSession();
        session.beginTransaction();

		Query<?> updateQuery =
                session.createQuery("UPDATE Product SET price = 55000 WHERE id = 1");

        int rowsUpdated = updateQuery.executeUpdate();

        System.out.println("\nRows Updated: " + rowsUpdated);

        session.getTransaction().commit();


        // delete operation
        session = factory.openSession();
        session.beginTransaction();

        Query<?> deleteQuery =
                session.createQuery("DELETE FROM Product WHERE id = 3");

        int rowsDeleted = deleteQuery.executeUpdate();

        System.out.println("Rows Deleted: " + rowsDeleted);

        session.getTransaction().commit();


        session.close();
        factory.close();
    }
}