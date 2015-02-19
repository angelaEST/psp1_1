package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.presentacion.PaintingText;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Angela Edith Suárez Torres
 */
public class App {

    /**
     * Mpetodo principal
     * @param args 
     */
    public static void main(String[] args) {
        BufferedReader reader ;
        FileReader fileReader ;
        ArrayList<Double> valores = new ArrayList<Double>();
        File archivo = new File(System.getProperty("user.dir") + File.separator + "target" + File.separator + "classes" + File.separator + "valores.txt");
        try {
            fileReader = new FileReader(archivo);
            reader = new BufferedReader(fileReader);
            String valor;
            try {
                valores = new ArrayList<Double>();
                System.out.println("Lectura exitosa de archivo. Se toman valores cargados desde el archivo valores.txt" + "\n");
                while ((valor = reader.readLine()) != null) {
                    System.out.println(valor);
                    valores.add(Double.valueOf(valor));
                }
            } catch (IOException ex) {
                System.out.println("Error con archivo. Se toma el array por defecto" + "\n");
                System.out.println(valores.toString() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error con lectura de archivo. Se toma el array por defecto cargado" + "\n" + ex);
            System.out.println(valores.toString() + "\n");
        }
        Calculo calculo = new Calculo();
        calculo.calcularAvg(valores);
        calculo.calcularVarianza(valores);
        calculo.calcularDesviacion();
        PaintingText paintingText = new PaintingText();
        paintingText.colorearResultado(calculo);
    }
}
