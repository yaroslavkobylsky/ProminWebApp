package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import com.promin_ism.dao.PartDao;
import org.hibernate.SessionFactory;

public class PartDaoImpl extends CommonDao implements PartDao {
    protected PartDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
