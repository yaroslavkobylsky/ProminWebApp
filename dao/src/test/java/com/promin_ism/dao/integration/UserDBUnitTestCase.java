package com.promin_ism.dao.integration;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.UserDao;
import com.promin_ism.dao.impl.UserDaoImpl;
import com.promin_ism.model.User;
import org.apache.log4j.Logger;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class UserDBUnitTestCase extends HibernateDbUnitTestCase {
    private static final Logger LOGGER = Logger.getLogger(UserDBUnitTestCase.class);
    private static final String USER_TEST_DATA_XML = "user.xml";
    private static final String USER5_NAME = "name5";
    private static final String USER5_NAME_UPDATE = "name5_update";
    private static final Long USER5_ID = new Long(5);
    private static final int USERS_NUMBER = 2;

    private UserDao userDao = new UserDaoImpl(HibernateUtilTest.getSessionFactory());

    protected IDataSet getDataSet() throws Exception {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(USER_TEST_DATA_XML);
        ReplacementDataSet userDataSet = new ReplacementDataSet(new FlatXmlDataSetBuilder().build(resourceAsStream));
        return userDataSet;
    }

    @Test
    public void testReadUser() throws DatabaseException {
        User user  = userDao.read(new Long(USER5_ID));
        LOGGER.debug(user.toString());
        assertTrue(user.getName().equals(USER5_NAME));
    }

    @Test
    public void testUpdateUser() throws DatabaseException {
        User user5 = userDao.read(new Long(USER5_ID));
        user5.setName(USER5_NAME_UPDATE);
        userDao.update(user5);
        user5 = userDao.read(new Long(USER5_ID));
        assertTrue(user5.getName().equals(USER5_NAME_UPDATE));
    }

    @Test
    public void findAllUsers() throws DatabaseException {
        List<User> users = userDao.findAll();
        for (User user : users){
            LOGGER.debug(user.toString());
        }
        assertEquals(users.size(), USERS_NUMBER);
    }
}
