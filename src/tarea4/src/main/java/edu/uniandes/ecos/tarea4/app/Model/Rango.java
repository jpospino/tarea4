/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea4.app.Model;

/**
* <h1>Rango</h1>
* Clase que almacena el resultado por cada paso del raango.
* imprime JSON con información del rango 
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-03-20
 */
public class Rango 
{
    private String nombreRango;
    private double valorRango;
    
    /***
     * Constructor de la clase rango
     * @param nombreRango nombre del rango
     * @param valorRango valor del rango
     */
    public Rango(String nombreRango, double valorRango)
    {
        this.nombreRango = nombreRango;
        this.valorRango = valorRango;
    }
    
    /***
     * Método para obtener JSON del rango
     * @return string con el JSON calculado
     */
    public String getJSON()
    {
        return "{\"nombreRango\" : \"" + this.nombreRango + "\", \"valorRango\" : \"" + this.valorRango +"\"}";
    }
}
