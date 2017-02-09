package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.PartDao;
import com.promin_ism.model.Part;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PartDaoImpl extends GenericDaoCRUD<Part> implements PartDao {
    private static final Logger LOGGER = Logger.getLogger(PartDaoImpl.class);

    public PartDaoImpl() {
    }

    public Part read(Long id) throws DatabaseException {
        return read(id, Part.class);
    }

    public List<Part> findAll() throws DatabaseException {
        return findAll(Part.class);
    }

    public boolean isNameUnique(String name) throws DatabaseException {
        try {
            LOGGER.debug("checking is name unique");
            List<Part> parts = getSessionFactory().getCurrentSession().createCriteria(Part.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();

            if (parts.size() > 0){
                LOGGER.debug("name is not unique: " + name);
                return false;
            }
            else {
                LOGGER.debug("name is unique: " + name);
                return true;
            }
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }

    public boolean isNameUniqueInEdit(String name, Long id) throws DatabaseException {
        try {
            LOGGER.debug("checking is name unique");
            List<Part> parts = getSessionFactory().getCurrentSession().createCriteria(Part.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .add(Restrictions.not(Restrictions.eq("id", id)))
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
                    .list();

            if (parts.size() > 0){
                LOGGER.debug("name is not unique: " + name);
                return false;
            }
            else {
                LOGGER.debug("name is unique: " + name);
                return true;
            }
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }
}
