package com.promin_ism.dao;

import com.promin_ism.model.StandardPart;

import java.util.List;

public interface StandardPartDao {
    StandardPart read(Long id) throws DatabaseException;
    void update(StandardPart standardPart) throws DatabaseException;
    Long create(StandardPart standardPart) throws DatabaseException;
    void delete(StandardPart standardPart) throws DatabaseException;
    List<StandardPart> findAll() throws DatabaseException;

    boolean isNameUnique(String name) throws DatabaseException;
}
