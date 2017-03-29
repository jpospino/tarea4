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
public class RangoTest extends TestCase {
    
    public RangoTest(String testName) {
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

    /**
     * Test of getJSON method, of class Rango.
     */
    public void testGetJSON() {
        System.out.println("getJSON");
        Rango rango = new Rango("VerySmall", 4.30981904117123);
        String result = rango.getJSON();
        
        assertEquals("{\"nombreRango\" : \"VerySmall\", \"valorRango\" : \"4.30981904117123\"}" , result);
    }
    
}
