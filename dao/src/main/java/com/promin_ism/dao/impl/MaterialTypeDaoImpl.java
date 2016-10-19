package com.promin_ism.dao.impl;

import com.promin_ism.dao.CommonDao;
import com.promin_ism.dao.MaterialTypeDao;
import org.hibernate.SessionFactory;

public class MaterialTypeDaoImpl extends CommonDao implements MaterialTypeDao {
    protected MaterialTypeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
