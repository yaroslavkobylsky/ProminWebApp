package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.PartDao;
import com.promin_ism.model.Part;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDaoImpl extends GenericDaoCRUD<Part> implements PartDao {

    public PartDaoImpl() {
    }

    public Part read(Long id) throws DatabaseException {
        return read(id, Part.class);
    }

    public List<Part> findAll() throws DatabaseException {
        return findAll(Part.class);
    }
}
