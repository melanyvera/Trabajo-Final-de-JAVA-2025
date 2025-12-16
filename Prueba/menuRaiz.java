package Prueba;
/*
Author: Gabriel Aquino
*/

public class menuRaiz {
    public static void main(String[] args) {
        Lector prueba = new Lector();
        prueba.leerArchivo();
        System.out.println("Archivos guardados en 4 - 0: " + prueba.leerArchivo()[4][0]);

    }
}
