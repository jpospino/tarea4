/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.tarea4.app.Model;

/**
* <h1>DatoHistorico</h1>
* Contenedora de cada uno de los datos históricos para calcular el
* rango 
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-03-20
 */
public class DatoHistorico 
{
    private String nombreParte;
    private int tamanhoParte;
    private int numeroItems;
    
    /***
     * Constructor de la clas
     * 
     * @param nombreParte nombre de la parte a la que se hace referencia
     * @param tamanhoParte tamaño de la parte
     * @param numeroItems cantidad de items que la conforman
     */
    public DatoHistorico(String nombreParte, int tamanhoParte, int numeroItems)
    {
        this.nombreParte = nombreParte;
        this.tamanhoParte = tamanhoParte;
        this.numeroItems = numeroItems;
    }
    
    /***
     * Método para calcular el logaritmo natura  entre el cosiente de las partes y el número de items
     * @return valor calculado
     */
    public double ln()
    {
        double cosiente = (this.tamanhoParte / this.numeroItems);
        return Math.log(cosiente);
    }
    
    /***
     * Metodo para calcular la diferencia entre el logaritmo natura y el promedio. este elvado 
     * al cuadrado
     * @param promedio del arreglo de tados históricos
     * @return valor calrculado
     */
    public double sLnMinusAvg(double promedio)
    {
        return (this.ln() - promedio) * (this.ln() - promedio); 
    }
}
