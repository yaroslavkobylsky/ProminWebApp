package com.promin_ism.dao.impl;

import com.promin_ism.dao.AssemblyDao;
import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.model.Assembly;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AssemblyDaoImpl extends GenericDaoCRUD<Assembly> implements AssemblyDao {
    private static final Logger LOGGER = Logger.getLogger(AssemblyDaoImpl.class);

    public Assembly read(Long id) throws DatabaseException {
        return read(id, Assembly.class);
    }

    public List<Assembly> findAll() throws DatabaseException {
        return findAll(Assembly.class);
    }

    public Assembly findByName(String name) throws DatabaseException {
        try {
            LOGGER.debug("checking is name unique");
            Assembly assembly = (Assembly) getSessionFactory().getCurrentSession().createCriteria(Assembly.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .uniqueResult();

            return assembly;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    public List<Assembly> findAllByName(String name) throws DatabaseException {
        List<Assembly> assemblies = new ArrayList();
        try {
            LOGGER.debug("checking is name unique");
            assemblies = getSessionFactory().getCurrentSession().createCriteria(Assembly.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .list();

            return assemblies;
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }
}
