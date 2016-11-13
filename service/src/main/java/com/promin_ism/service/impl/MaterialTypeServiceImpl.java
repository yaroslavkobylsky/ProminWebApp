package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.MaterialTypeDao;
import com.promin_ism.model.MaterialType;
import com.promin_ism.service.MaterialTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaterialTypeServiceImpl implements MaterialTypeService {
    @Autowired
    private MaterialTypeDao materialTypeDao;

    public MaterialType read(Long id) throws DatabaseException {
        return materialTypeDao.read(id);
    }

    public void update(MaterialType materialType) throws DatabaseException {
        materialTypeDao.update(materialType);
    }

    public Long create(MaterialType materialType) throws DatabaseException {
        return materialTypeDao.create(materialType);
    }

    public void delete(MaterialType materialType) throws DatabaseException {
        materialTypeDao.delete(materialType);
    }

    public List<MaterialType> findAll() throws DatabaseException {
        return materialTypeDao.findAll();
    }
}
