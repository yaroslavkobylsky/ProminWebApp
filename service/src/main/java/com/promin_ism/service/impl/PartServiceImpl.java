package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.PartDao;
import com.promin_ism.model.Part;
import com.promin_ism.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {
    @Autowired
    private PartDao partDao;

    public Part read(Long id) throws DatabaseException {
        return partDao.read(id);
    }

    public void update(Part part) throws DatabaseException {
        partDao.update(part);
    }

    public Long create(Part part) throws DatabaseException {
        return partDao.create(part);
    }

    public void delete(Part part) throws DatabaseException {
        partDao.delete(part);
    }

    public List<Part> findAll() throws DatabaseException {
        return partDao.findAll();
    }

    public boolean isNameUnique(String name) throws DatabaseException {
        return partDao.isNameUnique(name);
    }

    public boolean isNameUniqueInEdit(String name, Long id) throws DatabaseException {
        return partDao.isNameUniqueInEdit(name, id);
    }
}
