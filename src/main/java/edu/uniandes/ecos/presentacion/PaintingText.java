/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.presentacion;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.mundo.Medida;
import java.text.DecimalFormat;
import java.util.LinkedList;

/**
 *
 * @author Angela Edith Suárez Torres
 */
public class PaintingText {

    /**
     * Colorea el resultado por consola
     * @param calculo Objeto que contiene valores de size
     */
    public void colorearResultado(Calculo calculo) {

        LinkedList<Medida> medidas = calculo.calcularTamanio();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for (Medida medida : medidas) {
            System.out.println("\nEl resultado para " + medida.getMedida() + " es " + decimalFormat.format(medida.getValor())+" LOC");
        }
    }

}
