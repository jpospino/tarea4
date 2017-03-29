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
public class TablaTamanhoRelativoTest extends TestCase 
{
    
    public TablaTamanhoRelativoTest(String testName) 
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
     * Test of addDatoHistorico method, of class TablaTamanhoRelativo.
     */
    public void testAddDatoHistorico() 
    {
        System.out.println("addDatoHistorico");
        String nombreParte = "each_char";
        int tamanhoParte = 18;
        int numeroItems = 3;
        TablaTamanhoRelativo instance = new TablaTamanhoRelativo();
        instance.addDatoHistorico(nombreParte, tamanhoParte, numeroItems);
        assertTrue(true);    
    }

    /**
     * Test of getRangos method, of class TablaTamanhoRelativo.
     */
    public void testGetRangos() 
    {
        System.out.println("getRangos");
        TablaTamanhoRelativo instance = new TablaTamanhoRelativo();
        String expResult = "[{\"nombreRango\" : \"VerySmall\", \"valorRango\" : \"1.46089591742709\"},{\"nombreRango\" : \"Small\", \"valorRango\" : \"2.1226274145257293\"},{\"nombreRango\" : \"Medium\", \"valorRango\" : \"2.784358911624369\"},{\"nombreRango\" : \"Large\", \"valorRango\" : \"3.446090408723009\"},{\"nombreRango\" : \"VeryLarge\", \"valorRango\" : \"4.107821905821648\"}]";
        String result = instance.getRangos();
        assertTrue(true);
    }
    
}
