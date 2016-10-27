package com.promin_ism.dao;

import com.promin_ism.model.Material;

import java.util.List;

public interface MaterialDao {
    Material read(Long id) throws DatabaseException;
    void update(Material material) throws DatabaseException;
    Long create(Material material) throws DatabaseException;
    void delete(Material material) throws DatabaseException;
    List<Material> findAll() throws DatabaseException;
}
