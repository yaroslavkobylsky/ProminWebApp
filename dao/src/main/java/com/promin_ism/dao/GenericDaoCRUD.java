package com.promin_ism.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GenericDaoCRUD <T> {
    private static final Logger LOGGER = Logger.getLogger(GenericDaoCRUD.class);

    @Autowired
    private SessionFactory sessionFactory;

    protected T read(Long id, Class<T> tClass) throws DatabaseException {
        try {
            LOGGER.debug("reading");
            T t = (T)sessionFactory.getCurrentSession().get(tClass, id);
            return t;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    public Long create(T t) throws DatabaseException {
        try {
            LOGGER.debug("creating");
            Long id = (Long)sessionFactory.getCurrentSession().save(t);
            LOGGER.debug("was created with id:" + id);
            return id;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    public void update(T t) throws DatabaseException {
        try {
            LOGGER.debug("updating");
            sessionFactory.getCurrentSession().update(t);
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    public void delete(T t) throws DatabaseException {
        try {
            LOGGER.debug("deleting");
            sessionFactory.getCurrentSession().delete(t);
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    protected List<T> findAll(Class<T> tClass) throws DatabaseException {
        try {
            LOGGER.debug("getting list");
            List<T> tList = sessionFactory.getCurrentSession().createCriteria(tClass).list();
            return tList;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
