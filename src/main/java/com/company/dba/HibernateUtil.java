package com.company.dba;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static StandardServiceRegistry registry;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            System.out.println("CREATING INSTANCE OF DA");
            try {
                registry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();


                System.out.println("creating factory-------------------------");
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
                System.out.println("factory created-----------------------");
            } catch (HibernateException ex) {
                //StandardServiceRegistryBuilder.destroy(registry);
                ex.printStackTrace();
                sessionFactory = null;
            }
        }
        return sessionFactory;
    }
}
