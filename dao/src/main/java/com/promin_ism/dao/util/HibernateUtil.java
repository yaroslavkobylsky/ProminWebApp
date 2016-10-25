package com.promin_ism.dao.util;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.UserDao;
import com.promin_ism.dao.impl.UserDaoImpl;
import com.promin_ism.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final Logger LOGGER =  LogManager.getLogger(HibernateUtil.class);
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        getSessionFactory().close();
    }

    public static void main(String[] args) {
        LOGGER.debug("trying to init session factory");
        HibernateUtil.buildSessionFactory();
        LOGGER.debug("int session factory done");
        UserDao userDao = new UserDaoImpl(HibernateUtil.getSessionFactory());
        User user = new User();
        user.setName("Test user");
        user.setLogin("test Login");
        user.setPassword("Test Password");
        user.setUserType(User.USER_TYPE_EDITOR);
        try {
            userDao.create(user);
        } catch (DatabaseException e) {
            LOGGER.debug(e.getMessage());
        }

        HibernateUtil.shutdown();
    }
}
