package com.promin_ism.dao;

import com.promin_ism.model.MaterialType;

import java.util.List;

public interface MaterialTypeDao {
    MaterialType read(Long id) throws DatabaseException;
    void update(MaterialType materialType) throws DatabaseException;
    Long create(MaterialType materialType) throws DatabaseException;
    void delete(MaterialType materialType) throws DatabaseException;
    List<MaterialType> findAll() throws DatabaseException;
}
