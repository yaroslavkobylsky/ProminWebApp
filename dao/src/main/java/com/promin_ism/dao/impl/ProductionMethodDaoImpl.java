package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.ProductionMethodDao;
import com.promin_ism.model.ProductionMethod;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductionMethodDaoImpl extends GenericDaoCRUD<ProductionMethod> implements ProductionMethodDao {

    public ProductionMethod read(Long id) throws DatabaseException {
        return read(id, ProductionMethod.class);
    }

    public List<ProductionMethod> findAll() throws DatabaseException {
        return findAll(ProductionMethod.class);
    }

    public ProductionMethodDaoImpl() {
    }
}
