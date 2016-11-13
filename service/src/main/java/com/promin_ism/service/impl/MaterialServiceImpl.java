package com.promin_ism.service.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.MaterialDao;
import com.promin_ism.model.Material;
import com.promin_ism.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    private MaterialDao materialDao;

    public Material read(Long id) throws DatabaseException {
        return materialDao.read(id);
    }

    public void update(Material material) throws DatabaseException {
        materialDao.update(material);
    }

    public Long create(Material material) throws DatabaseException {
        return materialDao.create(material);
    }

    public void delete(Material material) throws DatabaseException {
        materialDao.delete(material);
    }

    public List<Material> findAll() throws DatabaseException {
        return materialDao.findAll();
    }
}
