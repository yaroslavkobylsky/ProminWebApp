package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.MaterialDao;
import com.promin_ism.model.Material;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialDaoImpl extends GenericDaoCRUD<Material> implements MaterialDao {

    public MaterialDaoImpl() {
    }

    public Material read(Long id) throws DatabaseException {
        return read(id, Material.class);
    }

    public List<Material> findAll() throws DatabaseException {
        return findAll(Material.class);
    }
}
