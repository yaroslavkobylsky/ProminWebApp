package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.ProductionMethodDao;
import com.promin_ism.model.ProductionMethod;
import com.promin_ism.service.ProductionMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductionMethodServiceImpl implements ProductionMethodService {
    @Autowired
    private ProductionMethodDao productionMethodDao;

    public ProductionMethod read(Long id) throws DatabaseException {
        return productionMethodDao.read(id);
    }

    public void update(ProductionMethod productionMethod) throws DatabaseException {
        productionMethodDao.update(productionMethod);
    }

    public Long create(ProductionMethod productionMethod) throws DatabaseException {
        return productionMethodDao.create(productionMethod);
    }

    public void delete(ProductionMethod productionMethod) throws DatabaseException {
        productionMethodDao.delete(productionMethod);
    }

    public List<ProductionMethod> findAll() throws DatabaseException {
        return productionMethodDao.findAll();
    }
}
