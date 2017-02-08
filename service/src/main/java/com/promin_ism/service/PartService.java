package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Part;

import java.util.List;

public interface PartService {
    Part read(Long id) throws DatabaseException;
    void update(Part part) throws DatabaseException;
    Long create(Part part) throws DatabaseException;
    void delete(Part part) throws DatabaseException;
    List<Part> findAll() throws DatabaseException;
    boolean isNameUnique(String name) throws DatabaseException;
    boolean isNameUniqueInEdit(String name, Long id) throws DatabaseException;
}
