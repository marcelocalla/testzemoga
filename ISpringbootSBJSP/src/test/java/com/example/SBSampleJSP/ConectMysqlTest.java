/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package com.example.SBSampleJSP;

import com.example.bean.Porfolio;
import java.sql.Connection;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author M. Calla
 */
public class ConectMysqlTest extends TestCase {
    
    public ConectMysqlTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testSetParams() {
        System.out.println("setParams");
        String user = "";
        String password = "";
        String ipDataBase = "";
        String Port = "";
        ConectMysql instance = new ConectMysql();
        instance.setParams(user, password, ipDataBase, Port);
        fail("The test case is a prototype.");
    }

    public void testGetConection() {
        System.out.println("getConection");
        String user = "";
        String password = "";
        String nameDataBase = "";
        String ipDataBas = "";
        String Port = "";
        ConectMysql instance = new ConectMysql();
        Connection expResult = null;
        Connection result = instance.getConection(user, password, nameDataBase, ipDataBas, Port);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testGetConectionNoParam() {
        System.out.println("getConectionNoParam");
        ConectMysql instance = new ConectMysql();
        Connection expResult = null;
        Connection result = instance.getConectionNoParam();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testCloseConection() {
        System.out.println("closeConection");
        ConectMysql instance = new ConectMysql();
        boolean expResult = false;
        boolean result = instance.closeConection();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testGetData() {
        System.out.println("getData");
        ConectMysql instance = new ConectMysql();
        List<Porfolio> expResult = null;
        List<Porfolio> result = instance.getData();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testInsertProfile() throws Exception {
        System.out.println("insertProfile");
        Porfolio pf = null;
        ConectMysql instance = new ConectMysql();
        boolean expResult = false;
        boolean result = instance.insertProfile(pf);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testUpdateProfile() {
        System.out.println("updateProfile");
        Porfolio pf = null;
        ConectMysql instance = new ConectMysql();
        boolean expResult = false;
        boolean result = instance.updateProfile(pf);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testDeleteProfile() throws Exception {
        System.out.println("deleteProfile");
        Porfolio pf = null;
        ConectMysql instance = new ConectMysql();
        boolean expResult = false;
        boolean result = instance.deleteProfile(pf);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    public void testGetInfoProperties() {
        System.out.println("getInfoProperties");
        ConectMysql instance = new ConectMysql();
        boolean expResult = false;
        boolean result = instance.getInfoProperties();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
