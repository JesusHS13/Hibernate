package com.example;

import java.util.UUID;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.example.entity.Foo;



/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        setupHibernate();
        System.out.println("Hello World!");
    }

    public static void setupHibernate() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .build();
        SessionFactory sessionFactory = new MetadataSources(registry)
                .addAnnotatedClass(Foo.class)
                .buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        
        //Foo foo = new Foo();
        //foo.id = 2;
        //foo.name="Jesús";
        //foo.dni="1234A";
        //session.persist(foo);
        Foo foo= session.get(Foo.class, 44);
        if (foo != null){ 
            session.remove(foo);
        }
        
        
        var tr = session.beginTransaction();
               tr.commit();
        session.close();

    }
}
