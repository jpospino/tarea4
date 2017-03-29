201710_CSOF5101_01 - CONCEPTOS AVANZADOS DE INGENIERÍA DE SOFTWARE
Tarea 3 - Calculo de regresión lineal
JUAN PABLO OSPINO SOLANO
20170306
repositorio: https://github.com/jpospino/tarea4.git


1. Compilación en maven
para compilar basta con digitar los siguientes comandos en la ruta ...\src\tarea4:

	mvn clean
	mvn package

también puede compilar utilizando el siguiente comando como lo sugiere heroku
	
	mvn clean install

y el comando para correr local:
	
	heroku local web


se adjunta dentro de las carpeta de test el resultado de la compilación y pruebas unitarias ver compilacion.txt.


2. Acceso a heroku

el programa está publicado en heroku como un servicio REST para su ejecución. sin embargo puede ejecutarlo via consola enviando la tablas usando un tipo de dato JSON con la siguiente estructura:

{nombre:"Nombre de la parte",tamanhoParte:"número entero con la cantidad de unidades LOC/Pages",numeroItems:"Numero de items necesario"}

en la carptea test podrá encontrar los archivos:

	JSON_LOCMethodData.txt
	JSON_PaginasCapitulos.txt

Contiene los JSON de los ejemplos de la tarea.

ahora la url de heroku es https://young-ridge-67409.herokuapp.com/tablaTamanhoRelativo a esto debe incluir en query string el valor de la tabla tal como se ve acontinuación

https://young-ridge-67409.herokuapp.com/tablaTamanhoRelativo?datosHistoricos={nombre:Preface,tamanhoParte:7,numeroItems:1},{nombre:Capitulo_1,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_2,tamanhoParte:10,numeroItems:1},{nombre:Capitulo_3,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_4,tamanhoParte:10,numeroItems:1},{nombre:Capitulo_5,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_6,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_7,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_8,tamanhoParte:12,numeroItems:1},{nombre:Capitulo_9,tamanhoParte:8,numeroItems:1},{nombre:Appendice_A,tamanhoParte:8,numeroItems:1},{nombre:Appendice_B,tamanhoParte:8,numeroItems:1},{nombre:Appendice_C,tamanhoParte:20,numeroItems:1},{nombre:Appendice_D,tamanhoParte:14,numeroItems:1},{nombre:Appendice_E,tamanhoParte:18,numeroItems:1},{nombre:Appendice_F,tamanhoParte:12,numeroItems:1}

puede consumir el servicio desde Postman como metodo get o puede hacerlo desde el navegador ingresando la dirección; copie y pegue la ruta
***************************************