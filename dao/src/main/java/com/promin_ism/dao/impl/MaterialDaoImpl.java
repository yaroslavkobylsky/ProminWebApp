package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.MaterialDao;
import com.promin_ism.model.Material;
import org.hibernate.SessionFactory;

import java.util.List;

public class MaterialDaoImpl extends GenericDaoCRUD<Material> implements MaterialDao {
    protected MaterialDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Material read(Long id) throws DatabaseException {
        return read(id, Material.class);
    }

    public List<Material> findAll() throws DatabaseException {
        return findAll(Material.class);
    }
}
