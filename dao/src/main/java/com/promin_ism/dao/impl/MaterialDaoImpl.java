package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import com.promin_ism.dao.MaterialDao;
import org.hibernate.SessionFactory;

public class MaterialDaoImpl extends CommonDao implements MaterialDao {
    protected MaterialDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
