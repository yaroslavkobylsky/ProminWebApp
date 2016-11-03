package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Material;

import java.util.List;

public interface MaterialService {
    Material read(Long id) throws DatabaseException;
    void update(Material material) throws DatabaseException;
    Long create(Material material) throws DatabaseException;
    void delete(Material material) throws DatabaseException;
    List<Material> findAll() throws DatabaseException;
}
