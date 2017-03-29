/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea4.app.Model;

import junit.framework.TestCase;

/**
 *
 * @author JuanPablo
 */
    public class DatoHistoricoTest extends TestCase {
    
    public DatoHistoricoTest(String testName) 
    {
        super(testName);
    }
    
    @Override
    protected void setUp() 
            throws Exception 
    {
        super.setUp();
    }
    
    @Override
    protected void tearDown() 
            throws Exception 
    {
        super.tearDown();
    }

    /**
     * Test of ln method, of class DatoHistorico.
     */
    public void testLn() 
    {
        System.out.println("ln");
        DatoHistorico instance = new DatoHistorico("each_char", 18, 3);
        double expResult = 1.7918;
        double result = instance.ln();
        assertEquals(expResult, round(result,4));
    }

    /**
     * Test of sLnMinusAvg method, of class DatoHistorico.
     */
    public void testSLnMinusAvg() 
    {
        System.out.println("sLnMinusAvg");
        double promedio = 2.8015;
        DatoHistorico instance = new DatoHistorico("each_char", 18, 3);
        double expResult = 1.0196;
        double result = instance.sLnMinusAvg(promedio);
        assertEquals(expResult, round(result,4));
    }
    
    public static double round(double value, int places) 
    {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
