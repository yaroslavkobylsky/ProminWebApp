package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.StandardPart;

import java.util.List;

public interface StandardPartService {
    StandardPart read(Long id) throws DatabaseException;
    void update(StandardPart standardPart) throws DatabaseException;
    Long create(StandardPart standardPart) throws DatabaseException;
    void delete(StandardPart standardPart) throws DatabaseException;
    List<StandardPart> findAll() throws DatabaseException;

    boolean isNameUnique(String name) throws DatabaseException;
    boolean isNameUniqueWhileEdit(String name, Long id) throws DatabaseException;
}
