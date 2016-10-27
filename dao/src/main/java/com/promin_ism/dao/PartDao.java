package com.promin_ism.dao;

import com.promin_ism.model.Part;

import java.util.List;

public interface PartDao {
    Part read(Long id) throws DatabaseException;
    void update(Part part) throws DatabaseException;
    Long create(Part part) throws DatabaseException;
    void delete(Part part) throws DatabaseException;
    List<Part> findAll() throws DatabaseException;
}
