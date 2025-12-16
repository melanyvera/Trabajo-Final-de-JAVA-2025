package Prueba;
/*
Author: Gabriel Aquino
*/

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.nio.charset.StandardCharsets;

public class Lector {
    
    private String [][]cadena;
    
    public Lector(){
    }
    public String [][]getCadena() {
        return cadena;
    }

    public void setCadena(String [][]cadena) {
        this.cadena = cadena;
    }

    public String[][] leerArchivo(){
        File file = new File("Prueba/eventos.csv");
 
        int totalLineas = 0;
        int totalColumnas = 0;
        //Lectura del archivo CSV y verificación de filas y columnas...
        try(BufferedReader contar = new BufferedReader(
        new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))){
            String fila;
            while((fila = contar.readLine()) != null){
                totalLineas++; //Contador de las filas...
                String[] columnas = fila.split(";");
                //Cuento las columnas  de cada fila...
                if(totalColumnas < columnas.length){
                    totalColumnas = columnas.length;
                }
            }
            
        }catch(IOException e){
        System.out.println("!!!  ---Error al leer el archivo--- !!!");
        e.printStackTrace();
        }

        //Carga del archivo CSV en un arreglo bidimensional...
        String[][] datos = new String[totalLineas][totalColumnas];
        try (BufferedReader leer = new BufferedReader(
        new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))) {
            String fila;
            int filaActual = 0;
            while ((fila = leer.readLine()) != null){
                String[] columnas = fila.split(";");
                for (int col = 0; col <= totalColumnas -1; col++) {
                    datos[filaActual][col] = columnas[col];
                }
                filaActual++;
            }
        System.out.println("Datos cargados exitosamente para su uso...");

        }catch (IOException e) {
            System.out.println("!!!  ---Error al guardar el archivo--- !!!");
            e.printStackTrace();
        }
        return datos;
    }
}
