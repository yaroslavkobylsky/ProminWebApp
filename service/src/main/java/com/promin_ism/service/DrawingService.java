package com.promin_ism.service;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Drawing;

import java.util.List;

public interface DrawingService {
    Drawing read(Long id) throws DatabaseException;
    void update(Drawing drawing) throws DatabaseException;
    Long create(Drawing drawing) throws DatabaseException;
    void delete(Drawing drawing) throws DatabaseException;
    List<Drawing> findAll() throws DatabaseException;
}
