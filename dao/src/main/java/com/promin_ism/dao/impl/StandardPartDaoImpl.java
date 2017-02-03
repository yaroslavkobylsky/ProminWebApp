package com.promin_ism.dao.impl;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.GenericDaoCRUD;
import com.promin_ism.dao.StandardPartDao;
import com.promin_ism.model.StandardPart;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StandardPartDaoImpl extends GenericDaoCRUD<StandardPart> implements StandardPartDao {
    private static final Logger LOGGER = Logger.getLogger(StandardPartDaoImpl.class);
    public StandardPart read(Long id) throws DatabaseException {
        return read(id, StandardPart.class);
    }

    public List<StandardPart> findAll() throws DatabaseException {
        return findAll(StandardPart.class);
    }

    public boolean isNameUnique(String name) throws DatabaseException {
        try {
            LOGGER.debug("checking is name unique");
            List<StandardPart> standardParts = getSessionFactory().getCurrentSession().createCriteria(StandardPart.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .list();

            if (standardParts.size() > 0){
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

    public boolean isNameUniqueWhileEdit(String name, Long id) throws DatabaseException {
        try {
            LOGGER.debug("checking is name unique");
            List<StandardPart> standardParts = getSessionFactory().getCurrentSession().createCriteria(StandardPart.class)
                    .add(Restrictions.eq("name", name.trim()))
                    .add(Restrictions.not(Restrictions.eq("id", id)))
                    .list();

            if (standardParts.size() > 0){
                LOGGER.debug("name is not unique in edit: " + name);
                return false;
            }
            else {
                LOGGER.debug("name is unique in edit: " + name);
                return true;
            }
        }
        catch (HibernateException e){
            LOGGER.error(e.getMessage());
            throw new DatabaseException(e.getMessage());
        }
    }
}
