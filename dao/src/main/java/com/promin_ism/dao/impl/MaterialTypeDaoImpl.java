package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.MaterialTypeDao;
import com.promin_ism.model.MaterialType;
import org.hibernate.SessionFactory;

import java.util.List;

public class MaterialTypeDaoImpl extends GenericDaoCRUD<MaterialType> implements MaterialTypeDao {
    protected MaterialTypeDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public MaterialType read(Long id) throws DatabaseException {
        return read(id, MaterialType.class);
    }

    public List<MaterialType> findAll() throws DatabaseException {
        return findAll(MaterialType.class);
    }
}
