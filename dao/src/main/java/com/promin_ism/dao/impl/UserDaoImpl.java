package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.UserDao;
import com.promin_ism.model.User;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

public class UserDaoImpl extends CommonDao implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public User read(Long id) throws DatabaseException {
        try {
            LOGGER.debug("reading user with id:" + id);
            return (User)getSessionFactory().getCurrentSession().get(User.class, id);
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }

    }

    public void update(User user) throws DatabaseException {
        try {
            LOGGER.debug("updating user with id:" + user.getId());
            getSessionFactory().getCurrentSession().update(user);
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }


    }

    public Long create(User user) throws DatabaseException {
        Session session = getSessionFactory().getCurrentSession();
        try {
            LOGGER.debug("creating user");
            session.getTransaction().begin();
            Long id = (Long)session.save(user);
            LOGGER.debug("user was created with id:" + id);
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

    public void delete(User user) throws DatabaseException {
        try{
            LOGGER.debug("deleting user with id:" + user.getId());
            getSessionFactory().getCurrentSession().delete(user);
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }

    }

    public List<User> findAll() throws DatabaseException {
        try {
            LOGGER.debug("getting users list");
            return getSessionFactory().getCurrentSession().createCriteria(User.class).list();
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }

    }
}
