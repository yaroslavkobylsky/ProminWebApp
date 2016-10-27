package com.promin_ism.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class GenericDaoCRUD <T> {
    private static final Logger LOGGER = Logger.getLogger(GenericDaoCRUD.class);
    private SessionFactory sessionFactory;

    protected GenericDaoCRUD(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    protected T read(Long id, Class<T> tClass) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            session.getTransaction().begin();
            LOGGER.debug("reading");
            T t = (T)getSessionFactory().getCurrentSession().get(tClass, id);
            session.getTransaction().commit();
            return t;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            session.getTransaction().rollback();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            if (session.isOpen()){
                LOGGER.debug("closing session");
                session.close();
            }
        }
    }

    public Long create(T t) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            LOGGER.debug("creating");
            session.getTransaction().begin();
            Long id = (Long)session.save(t);
            LOGGER.debug("was created with id:" + id);
            session.getTransaction().commit();
            return id;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            session.getTransaction().rollback();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            if (session.isOpen()){
                LOGGER.debug("closing session");
                session.close();
            }
        }
    }

    public void update(T t) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            LOGGER.debug("updating");
            session.getTransaction().begin();
            getSessionFactory().getCurrentSession().update(t);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            session.getTransaction().rollback();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            if (session.isOpen()){
                LOGGER.debug("closing session");
                session.close();
            }
        }

    }

    public void delete(T t) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            LOGGER.debug("deleting");
            session.getTransaction().begin();
            getSessionFactory().getCurrentSession().delete(t);
            session.getTransaction().commit();
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            session.getTransaction().rollback();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            if (session.isOpen()){
                LOGGER.debug("closing session");
                session.close();
            }
        }
    }

    protected List<T> findAll(Class<T> tClass) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            LOGGER.debug("getting list");
            session.getTransaction().begin();
            List<T> tList = getSessionFactory().getCurrentSession().createCriteria(tClass).list();
            session.getTransaction().commit();
            return tList;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            session.getTransaction().rollback();
            throw new DatabaseException(e.getMessage());
        }
        finally {
            if (session.isOpen()){
                LOGGER.debug("closing session");
                session.close();
            }
        }
    }


}
