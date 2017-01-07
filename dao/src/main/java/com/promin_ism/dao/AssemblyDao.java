package com.promin_ism.dao;

import com.promin_ism.model.Assembly;

import java.util.List;

public interface AssemblyDao {
    Assembly read(Long id) throws DatabaseException;
    void update(Assembly assembly) throws DatabaseException;
    Long create(Assembly assembly) throws DatabaseException;
    void delete(Assembly assembly) throws DatabaseException;
    List<Assembly> findAll() throws DatabaseException;
    Assembly findByName(String name) throws DatabaseException;
    List<Assembly> findAllByName(String name) throws DatabaseException;
}
