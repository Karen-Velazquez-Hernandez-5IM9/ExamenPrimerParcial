/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Clases.Conversiones;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletMoneda extends HttpServlet {
    private int n1;
    private float r;
    private String ope;
    
    @Override
    public void doPost(HttpServletRequest peticion, HttpServletResponse respuesta)
            throws ServletException, IOException
    {
        n1= Integer.parseInt(peticion.getParameter("Peso"));
        ope = peticion.getParameter("Moneda");
        Conversiones conv= new Conversiones();
        
            if(ope.equals("Yen")){
                r=conv.Yen(n1);
            }
            else{
                if(ope.equals("Dolar")){
                    r=conv.Dolar(n1);
                }
            }
        PrintWriter out= new PrintWriter(respuesta.getOutputStream());
        out.println("<html>");
        out.println("<head><title>Respuesta</title></head>");
        out.println("<body><div><center>");
        out.println("<br><hr><br>");
        out.println("<h3>El resultado de la conversión es: "+ r + "</h3>");
        out.println("<br><hr><br>");
        out.println("<h2>Es todo, hasta luego</h2>");
        out.println("</center></div></body>");
        out.println("</html>");
        out.close();
    }    
}

