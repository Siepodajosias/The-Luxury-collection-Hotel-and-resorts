package com.Session;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import Base_Donnee.Authentification;
import Base_Donnee.Avoir;
import Base_Donnee.AvoirId;
import Base_Donnee.Chambres;
import Base_Donnee.Clients;
import Base_Donnee.Employes;
import Base_Donnee.Factures;
import Base_Donnee.Occupation;
import Base_Donnee.Reservations;
import Base_Donnee.Services;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://eu-cdbr-west-01.cleardb.com:3306/heroku_88ae11bd39df693?useSSL=false");
                settings.put(Environment.USER, "b8abf3aa1ab74b");
                settings.put(Environment.PASS, "be1020e3");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                settings.put(Environment.SHOW_SQL, "false");

                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(Authentification.class);
                configuration.addAnnotatedClass(Chambres.class);
                configuration.addAnnotatedClass(Clients.class);
                configuration.addAnnotatedClass(Employes.class);
                configuration.addAnnotatedClass(Factures.class);
                configuration.addAnnotatedClass(Occupation.class);
                configuration.addAnnotatedClass(Reservations.class);
                configuration.addAnnotatedClass(Services.class);
                configuration.addAnnotatedClass(Avoir.class);
                configuration.addAnnotatedClass(AvoirId.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
