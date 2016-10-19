package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import com.promin_ism.dao.UserDao;
import org.hibernate.SessionFactory;

public class UserDaoImpl extends CommonDao implements UserDao {




    protected UserDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
