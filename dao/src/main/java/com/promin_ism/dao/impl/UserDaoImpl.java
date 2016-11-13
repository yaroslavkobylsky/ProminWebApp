package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.UserDao;
import com.promin_ism.model.User;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
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


}
