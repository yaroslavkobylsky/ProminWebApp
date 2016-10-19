package com.promin_ism.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

public class CommonDao {
    private static final Logger LOGGER = LogManager.getLogger(CommonDao.class);
    private SessionFactory sessionFactory;

    protected CommonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
