package com.gugawag.pdist.servlets;

import jakarta.ejb.EJB;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/calculadora.do"})
public class CalculadoraServlet {

    @EJB(lookup = "java:global/calculadoraejb-1.0-SNAPSHOT/calculadoraService")
    private model.CalculadoraIF calculadora;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter resposta = response.getWriter();
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        resposta.println(calculadora.somar(num1, num2));
    }
}
