package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.StandardPartDao;
import com.promin_ism.model.StandardPart;
import com.promin_ism.service.StandardPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StandardPartServiceImpl implements StandardPartService {
    @Autowired
    private StandardPartDao standardPartDao;

    public StandardPart read(Long id) throws DatabaseException {
        return standardPartDao.read(id);
    }

    public void update(StandardPart standardPart) throws DatabaseException {
        standardPartDao.update(standardPart);
    }

    public Long create(StandardPart standardPart) throws DatabaseException {
        return standardPartDao.create(standardPart);
    }

    public void delete(StandardPart standardPart) throws DatabaseException {
        standardPartDao.delete(standardPart);
    }

    public List<StandardPart> findAll() throws DatabaseException {
        return standardPartDao.findAll();
    }

    public boolean isNameUnique(String name) throws DatabaseException {
        return standardPartDao.isNameUnique(name);
    }

    public boolean isNameUniqueWhileEdit(String name, Long id) throws DatabaseException {
        return standardPartDao.isNameUniqueWhileEdit(name, id);
    }
}
