package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.DrawingDao;
import com.promin_ism.model.Drawing;
import com.promin_ism.service.DrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrawingServiceImpl implements DrawingService {
    @Autowired
    DrawingDao drawingDao;

    public Drawing read(Long id) throws DatabaseException {
        return drawingDao.read(id);
    }

    public void update(Drawing drawing) throws DatabaseException {
        drawingDao.update(drawing);
    }

    public Long create(Drawing drawing) throws DatabaseException {
        return drawingDao.create(drawing);
    }

    public void delete(Drawing drawing) throws DatabaseException {
        drawingDao.delete(drawing);
    }

    public List<Drawing> findAll() throws DatabaseException {
        return drawingDao.findAll();
    }
}
