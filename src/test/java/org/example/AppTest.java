/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.example;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Richard
 */
public class AppTest
{
    
    public AppTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of main method, of class App.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        App.main(args);

    }

    /**
     * Test of start method, of class App.
     */
    @Test
    public void testStart()
    {
        System.out.println("start");
        App instance = new App();
        instance.start();
    }

    /**
     * Test of readFile method, of class App.
     */
    @Test
    public void testReadFile()
    {
        System.out.println("readFile");
        File file = new File("JC_Results.txt");
        App instance = new App();
        instance.readFile(file);
    }

    /**
     * Test of selectFiveGrades method, of class App.
     */
    @Test
    public void testSelectFiveGrades()
    {
        System.out.println("selectFiveGrades");
        int[] codes = {1, 2, 3, 8, 11, 46, 12, 34};
        int[] grades = {55, 60, 70, 44, 67, 65, 100, 59};
        App instance = new App();
        int[] expResult = instance.selectFiveGrades(codes, grades);
        int[] result = instance.selectFiveGrades(codes, grades);
        assertArrayEquals(expResult, result);

    }

    /**
     * Test of calculateAverage method, of class App.
     */
    @Test
    public void testCalculateAverage()
    {
        System.out.println("calculateAverage");
        int[] selectedGrades = {55, 60, 70, 44, 67};
        App instance = new App();
        double expResult = 59.20;
        double result = instance.calculateAverage(selectedGrades);
        assertEquals(expResult, result, 0.0);

    }
    
}
