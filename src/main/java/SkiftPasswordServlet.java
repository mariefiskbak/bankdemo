import Domæneobjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SkiftPasswordServlet", value = "/SkiftPasswordServlet")
public class SkiftPasswordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/SkiftPassword.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession session = request.getSession();

        Konto konto = (Konto) session.getAttribute("konto");


        String pass1 = request.getParameter("nytPassword1");
        String pass2 = request.getParameter("nytPassword2");

        if ((pass1.length() < 3)){
            request.setAttribute("fejlSkiftPassword", "Kodeordet er ikke lang nok");
            request.getRequestDispatcher("SkiftPassword.jsp").forward(request, response);
        }

        if (!pass1.equals(pass2))
        {
            request.setAttribute("fejlSkiftPassword", "Kodeordene er ikke ens");
            request.getRequestDispatcher("SkiftPassword.jsp").forward(request, response);
        }


        konto.setKode(pass1);
        request.getRequestDispatcher("index.jsp").forward(request,response);


                //vi er i et sessionscope. Brugernavnet må ligge et sted. Vi skal hente det, så vi kan overskrive passwordet

    }
}
