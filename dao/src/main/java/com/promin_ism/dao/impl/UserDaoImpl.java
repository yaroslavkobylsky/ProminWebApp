package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.UserDao;
import com.promin_ism.model.User;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends GenericDaoCRUD<User> implements UserDao {
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    public UserDaoImpl() {
    }

    public User read(Long id) throws DatabaseException {
        return read(id, User.class);
    }

    public List<User> findAll() throws DatabaseException {
        return findAll(User.class);
    }

    public User getByLoginPass(String login, String password) throws DatabaseException {
        try {
            return (User)getSessionFactory().getCurrentSession().createCriteria(User.class)
                    .add(Restrictions.eq("login",login))
                    .add(Restrictions.eq("password", password))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .uniqueResult();
        }
        catch (HibernateException e){
            LOGGER.error("error in find user by login and password", e);
            throw new DatabaseException(e.getMessage());
        }
    }


}
