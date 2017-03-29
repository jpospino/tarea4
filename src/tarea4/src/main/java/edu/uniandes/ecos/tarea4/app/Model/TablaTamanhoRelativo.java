/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea4.app.Model;

import java.util.ArrayList;
import java.util.List;

/**
* <h1>TablaTamanhoRelativo</h1>
* Clase para el calculo de todos los valores del rango
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-03-20
 */
public class TablaTamanhoRelativo 
{
    private List<DatoHistorico> datosHistoricos;
    
    /***
     * Constructor de la clase TablaTamanhoRelativo
     */
    public TablaTamanhoRelativo()
    {
        this.datosHistoricos = new ArrayList<DatoHistorico>();
    }
    
    /***
     * Método para insertar items al arreglo
     * @param nombreParte nombre de la parte del nuevo dato historico
     * @param tamanhoParte tamaño de la parte del nuevo dato historico
     * @param numeroItems  numero de items del nuervo dato historico
     */
    public void addDatoHistorico(String nombreParte, int tamanhoParte, int numeroItems)
    {
        this.datosHistoricos.add(new DatoHistorico(nombreParte, tamanhoParte, numeroItems));
    }
    
    /***
     * Calculo del promedio logaritmico
     * @return valor calculado
     */
    private double getAvg()
    {
        double sumatoria = 0.0;
        
        for(DatoHistorico datoHistorico: this.datosHistoricos)
        {
            sumatoria += datoHistorico.ln();
        }
        
        return sumatoria / this.datosHistoricos.size();
    }
    
    /***
     * método para el calculo de la varianza 
     * @return valor calculado
     */
    private double getVarianza()
    {
        double sumatoria = 0.0;
        double promedio = getAvg();
        
        for(DatoHistorico datoHistorico: this.datosHistoricos)
        {
            sumatoria += datoHistorico.sLnMinusAvg(promedio);
        }
        
        return (sumatoria / (this.datosHistoricos.size() - 1));
    }
    
    /***
     * Métdo que obtiene el JSON con los resultados finales de los calculos
     * @return JSON con los valores calculados
     */
    public String getRangos()
    {
        double desviacionStandard = Math.sqrt(getVarianza());
        double promedio = this.getAvg();
        
        Rango rangoVS = new Rango("VerySmall", Math.exp(promedio - (2 * desviacionStandard)));
        Rango rangoS = new Rango("Small", Math.exp(promedio - desviacionStandard));
        Rango rangoM = new Rango("Medium", Math.exp(promedio));
        Rango rangoL = new Rango("Large", Math.exp(promedio + desviacionStandard));
        Rango rangoVL = new Rango("VeryLarge", Math.exp(promedio + (2 * desviacionStandard)));
        
        return "[" + rangoVS.getJSON() 
                + "," + rangoS.getJSON()
                + "," + rangoM.getJSON()
                + "," + rangoL.getJSON() 
                + "," + rangoVL.getJSON()
                + "]";
    }
}
