package com.promin_ism.model;

import org.junit.Assert;
import org.junit.Before;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.*;

public class AssemblyTest {
    private Assembly testAssembly;
    private Part testPart;

    @Before
    public void init(){
        testAssembly = new Assembly();
        testAssembly.setId(new Long(1));

        testPart = new Part();
        testPart.setName("test part 1");
        testPart.setIsPurchased(true);

        testAssembly.addPart(testPart, new Long(5));

        Part part2 = new Part();
        part2.setName("test part 2");
        part2.setIsPurchased(false);

        testAssembly.addPart(part2, new Long(3));

        Assembly assembly = new Assembly();
        assembly.setId(new Long(2));
        assembly.addPart(testPart, new Long(2));
        testAssembly.addAssembly(assembly, new Long(2));
    }

    @org.junit.Test
    public void getListOfPurchasedParts() throws Exception {
        Map<Part, Long> listOfPurchesedParts = testAssembly.getListOfPurchasedParts();
        Assert.assertTrue(listOfPurchesedParts.size() == 1);
        Part part = listOfPurchesedParts.keySet().stream().findFirst().get();
        Assert.assertTrue(part.equals(testPart));
        Long numberOfParts = listOfPurchesedParts.values().stream().findFirst().get();
        System.out.println("number of parts: " + numberOfParts);
        Assert.assertTrue(numberOfParts.equals(new Long(9)));
    }

}