package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;

import java.util.List;

public interface AssemblyService {
    Assembly read(Long id) throws DatabaseException;
    void update(Assembly assembly) throws DatabaseException;
    Long create(Assembly assembly) throws DatabaseException;
    void delete(Assembly assembly) throws DatabaseException;
    List<Assembly> findAll() throws DatabaseException;
}
