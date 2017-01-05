package com.promin_ism.service.impl;

import com.promin_ism.dao.AssemblyDao;
import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AssemblyServiceImpl implements AssemblyService {

    @Autowired
    private AssemblyDao assemblyDao;

    public Assembly read(Long id) throws DatabaseException {
        return assemblyDao.read(id);
    }

    public void update(Assembly assembly) throws DatabaseException {
        assemblyDao.update(assembly);
    }

    public Long create(Assembly assembly) throws DatabaseException {
        return assemblyDao.create(assembly);
    }

    public void delete(Assembly assembly) throws DatabaseException {
        assemblyDao.delete(assembly);
    }

    public List<Assembly> findAll() throws DatabaseException {
        return assemblyDao.findAll();
    }
}
