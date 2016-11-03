package com.promin_ism.dao.integration;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.MaterialDao;
import com.promin_ism.dao.impl.MaterialDaoImpl;
import com.promin_ism.model.Material;
import org.apache.log4j.Logger;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ReplacementDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MaterialDBUnitTestCase  extends HibernateDbUnitTestCase {
    private static final Logger LOGGER = Logger.getLogger(MaterialDBUnitTestCase.class);
    private static String MATERIAL_TEST_DATA_XML = "material.xml";
    private static String MATERIAL5_NAME = "name5";
    private static String MATERIAL5_NAME_UPDATED = "name5_updated";
    private static Long MATERIAL5_ID = new Long(5);
    private static int MATERIALS_SIZE = 2;
    private MaterialDao materialDao = new MaterialDaoImpl(HibernateUtilTest.getSessionFactory());

    protected IDataSet getDataSet() throws Exception {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream(MATERIAL_TEST_DATA_XML);
        ReplacementDataSet userDataSet = new ReplacementDataSet(new FlatXmlDataSetBuilder().build(resourceAsStream));
        return userDataSet;
    }

    @Test
    public void testReadMaterial() throws DatabaseException {
        Material material = materialDao.read(MATERIAL5_ID);
        assertTrue(material.getName().equals(MATERIAL5_NAME));
    }

    @Test
    public void testUpdateMaterial() throws DatabaseException {
        Material material = materialDao.read(MATERIAL5_ID);
        assertTrue(material.getName().equals(MATERIAL5_NAME));
        material.setName(MATERIAL5_NAME_UPDATED);
        materialDao.update(material);
        material = materialDao.read(MATERIAL5_ID);
        assertTrue(material.getName().equals(MATERIAL5_NAME_UPDATED));
    }

    @Test
    public void testFindAllMaterials() throws DatabaseException {
        List<Material> materials = materialDao.findAll();
        assertTrue(materials.size() == MATERIALS_SIZE);
    }
}

