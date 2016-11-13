package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.MaterialTypeDao;
import com.promin_ism.model.MaterialType;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MaterialTypeDaoImpl extends GenericDaoCRUD<MaterialType> implements MaterialTypeDao {

    public MaterialTypeDaoImpl() {
    }

    public MaterialType read(Long id) throws DatabaseException {
        return read(id, MaterialType.class);
    }

    public List<MaterialType> findAll() throws DatabaseException {
        return findAll(MaterialType.class);
    }
}
