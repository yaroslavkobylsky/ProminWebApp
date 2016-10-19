package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import org.hibernate.SessionFactory;

public class ProductionMethodDaoImpl extends CommonDao implements com.promin_ism.dao.ProductionMethodDao {

    protected ProductionMethodDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
