package com.promin_ism.dao.impl;

import com.promin_ism.dao.AssemblyDao;
import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.model.Assembly;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class AssemblyDaoImpl extends GenericDaoCRUD<Assembly> implements AssemblyDao {
    public Assembly read(Long id) throws DatabaseException {
        return read(id, Assembly.class);
    }

    public List<Assembly> findAll() throws DatabaseException {
        return findAll(Assembly.class);
    }
}
