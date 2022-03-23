package com.example.bank;

import Domæneobjekter.Konto;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    Map<String, Konto> kontoMap = new TreeMap<>();

    public void init() {
    Konto konto = new Konto("markus", "markus", 40);
    Konto konto1 = new Konto("micki", "micki", 3000000);
    Konto konto2 = new Konto("otto", "otto", 1);
    Konto konto3 = new Konto("timi", "timi", 0);
    Konto konto4 = new Konto("bo", "bo", 455);

    kontoMap.put(konto.getNavn(), konto);
    kontoMap.put(konto1.getNavn(), konto1);
    kontoMap.put(konto2.getNavn(), konto2);
    kontoMap.put(konto3.getNavn(), konto3);
    kontoMap.put(konto4.getNavn(), konto4);

        ServletContext servletContext = getServletContext();
        servletContext.setAttribute("konti", kontoMap);


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    public void destroy() {
    }
}