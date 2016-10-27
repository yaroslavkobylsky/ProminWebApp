package com.promin_ism.dao;

import com.promin_ism.model.ProductionMethod;

import java.util.List;

public interface ProductionMethodDao {
    ProductionMethod read(Long id) throws DatabaseException;
    void update(ProductionMethod productionMethod) throws DatabaseException;
    Long create(ProductionMethod productionMethod) throws DatabaseException;
    void delete(ProductionMethod productionMethod) throws DatabaseException;
    List<ProductionMethod> findAll() throws DatabaseException;
}
