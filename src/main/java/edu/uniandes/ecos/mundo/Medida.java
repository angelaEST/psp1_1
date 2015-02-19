/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.mundo;

/******************************************************************/
/* Program Assignment:4                                                      
/* Name: Angela Edith Suárez Torres                                                                                  
/* Date: 16/02/15                  
/* Description: Contiene los atributos para rango del size
/******************************************************************/
public class Medida {

    private String medida;
    private double valor;

    public Medida(String medida, double valor) {
        this.medida = medida;
        this.valor = valor;
    }

   
    
    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

   

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
