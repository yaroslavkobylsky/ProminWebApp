package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.DrawingDao;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.model.Drawing;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DrawingDaoImpl extends GenericDaoCRUD<Drawing> implements DrawingDao {
    public Drawing read(Long id) throws DatabaseException {
        return super.read(id, Drawing.class);
    }

    public List<Drawing> findAll() throws DatabaseException {
        return super.findAll(Drawing.class);
    }
}
