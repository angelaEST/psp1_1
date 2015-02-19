/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.presentacion;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.mundo.Medida;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

/**
 *
 * @author Angela Edith Suárez Torres
 */
public class PaintingWeb {

    public static void presentarOpcion(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP1.1 RESIZING!</h1>");

        pw.write("<form action=\"sizaLOC\" method=\"post\"> \n"
                + "    <input type=\"submit\" value=\"Consultar Rangos\">\n"
                + "</form> ");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp, Calculo calculo)
            throws ServletException, IOException {

        LinkedList<Medida> medidas = calculo.calcularTamanio();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        for (Medida medida : medidas) {
            resp.getWriter().println("\nEl resultado para  " + medida.getMedida() + " es " + decimalFormat.format(medida.getValor()));

        }

    }
}
