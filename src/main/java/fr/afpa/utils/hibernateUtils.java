package fr.afpa.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class hibernateUtils {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {


        if(sessionFactory==null) {
            Configuration configuration = new Configuration().configure("fr/afpa/config/hibernate.cfg.xml");

            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).buildServiceRegistry();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }

        return sessionFactory;
    }



}
