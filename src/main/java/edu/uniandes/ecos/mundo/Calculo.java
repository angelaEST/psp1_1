/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Angela Edith Suárez Torres
 */
public class Calculo {

    private double avg;
    private double varianza;
    private double desviacion;

    private static final String VERY_SMALL = " VERY SMALL ";
    private static final String SMALL = " SMALL ";
    private static final String MEDIUM = " MEDIUM ";
    private static final String LARGE = " LARGE ";
    private static final String VERY_LARGE = " VERY LARGE ";

    /**
     * Calcula promedio de logaritmos
     * @param valores Lista con valores cargados desde archivo
     */
    public void calcularAvg(ArrayList<Double> valores) {
        double sumatoria = 0;
        for (Double valore : valores) {
            sumatoria = sumatoria + (Math.log(valore));
        }
        this.setAvg(sumatoria / valores.size());
    }

    /**
     * Calcula varianza
     * @param valores Lista con valores cargados desde archivo
     */
    public void calcularVarianza(ArrayList<Double> valores) {
        double sumatoria = 0;
        for (Double valore : valores) {
            sumatoria = sumatoria + (Math.pow((Math.log(valore)) - this.getAvg(), 2));
        }
        this.setVarianza(sumatoria / (valores.size() - 1));
    }

    /**
     * Calcula desviación a partir de varianza calculada
     */
    public void calcularDesviacion() {
        this.setDesviacion(Math.sqrt(this.getVarianza()));
    }

    /**
     * Efectúa cálculos para cada medida
     * @return 
     */
    public LinkedList<Medida> calcularTamanio() {
        LinkedList<Medida> medidas = new LinkedList<Medida>();

        medidas.add(new Medida(VERY_SMALL, Math.exp(this.getAvg() - (2 * (this.getDesviacion())))));
        medidas.add(new Medida(SMALL, Math.exp(this.getAvg() - (this.getDesviacion()))));
        medidas.add(new Medida(MEDIUM, Math.exp(this.getAvg())));
        medidas.add(new Medida(LARGE, Math.exp(this.getAvg() + this.getDesviacion())));
        medidas.add(new Medida(VERY_LARGE, Math.exp(this.getAvg() + (2 * (this.getDesviacion())))));
        return medidas;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getVarianza() {
        return varianza;
    }

    public void setVarianza(double varianza) {
        this.varianza = varianza;
    }

    public double getDesviacion() {
        return desviacion;
    }

    public void setDesviacion(double desviacion) {
        this.desviacion = desviacion;
    }

}
