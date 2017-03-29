package edu.uniandes.ecos.tarea4.app;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import edu.uniandes.ecos.tarea4.app.Model.*;

import static spark.Spark.*;

/**
* <h1>App</h1>
* vista de usuario y contenedora del método main 
* de la solución.
*
* @author  Juan Pablo Ospino Solano
* @version 1.0
* @since   2017-02-20
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println(ejecutar("{nombre:each_char,tamanhoParte:18,numeroItems:3},{nombre:string_read,tamanhoParte:18,numeroItems:3},{nombre:singler_character,tamanhoParte:25,numeroItems:3},{nombre:each_line,tamanhoParte:31,numeroItems:3},{nombre:single_char,tamanhoParte:37,numeroItems:3},{nombre:string_builder,tamanhoParte:82,numeroItems:5},{nombre:stringmanage,tamanhoParte:82,numeroItems:4},{nombre:list_clump,tamanhoParte:87,numeroItems:4},{nombre:list_clip,tamanhoParte:89,numeroItems:4},{nombre:string_decrementer,tamanhoParte:230,numeroItems:10},{nombre:char,tamanhoParte:85,numeroItems:3},{nombre:character,tamanhoParte:87,numeroItems:3},{nombre:converter,tamanhoParte:558,numeroItems:10}"));
        
        
        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
        
        get("/tablaTamanhoRelativo",  "application/json", (req, res) -> {
            String JSONString = req.queryParams("datosHistoricos").toString();
            return ejecutar(JSONString);
        });
    }
    
    /***
     * Metodos para ejecutar el código
     * @param datosHistoricos retorna el JSON con del 
     * @return 
     */
    public static String ejecutar(String datosHistoricos)
    {
        String[] valores = datosHistoricos.split("},");
        String salida = "";
        TablaTamanhoRelativo tablaTamanhoRelativo = new TablaTamanhoRelativo();
            
        for(int i = 0; i < valores.length; i++)  
        {
            String historico =  valores[i].replace("{", "").replace("[", "").replace("]", "").replace(" ", "").replace("}", "");
            
            if(historico.length() == 0)
                continue;
            
            String[] datosHistorico = historico.split(",");
            
            String nombre = "";
            int tamanhoParte = 0;
            int numeroItems = 0;
                
            for(int j=0 ; j<=2 ; j++)
            {                
                switch(datosHistorico[j].split(":")[0].toUpperCase())
                {
                    case "NOMBRE":
                        nombre = datosHistorico[j].split(":")[1];
                        break;
                    case "TAMANHOPARTE":
                        tamanhoParte = Integer.parseInt(datosHistorico[j].split(":")[1]);
                        break;
                    case "NUMEROITEMS":
                        numeroItems = Integer.parseInt(datosHistorico[j].split(":")[1]);
                        break;
                }
            }
            
            tablaTamanhoRelativo.addDatoHistorico(nombre, tamanhoParte, numeroItems);
        }
        
        salida = tablaTamanhoRelativo.getRangos();
            
        return salida;
    }
}
