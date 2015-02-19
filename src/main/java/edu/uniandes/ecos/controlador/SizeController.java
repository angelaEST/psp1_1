/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.controlador;

import edu.uniandes.ecos.mundo.Calculo;
import edu.uniandes.ecos.presentacion.PaintingWeb;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 *
 * @author Angela Edith Suarez Torres
 */
public class SizeController extends HttpServlet {

    public static void main(String[] args) {
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new SizeController()), "/*");
        try {
            server.start();
            server.join();
        } catch (Exception ex) {
            Logger.getLogger(SizeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        

    }
    /**
     * Efectúa la lectura del archivo y envía ek resultado para ser coloreado
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader;
        FileReader fileReader;
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
                System.out.println("Error con archivo. " + "\n");
                System.out.println(valores.toString() + "\n");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error con lectura de archivo." + "\n" + ex);
            System.out.println(valores.toString() + "\n");
        }
        Calculo calculo = new Calculo();
        calculo.calcularAvg(valores);
        calculo.calcularVarianza(valores);
        calculo.calcularDesviacion();
        PaintingWeb.showResults(req, resp, calculo);
    }
}
