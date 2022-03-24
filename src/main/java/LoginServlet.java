import Domæneobjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String navn = request.getParameter("name");
        String kode = request.getParameter("pass");

        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        Konto konto = kontoMap.getOrDefault(navn, null);

        if(konto == null) {
            request.setAttribute("fejl", "kontoen fandtes ikke");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(!konto.getKode().equals(kode)){
            request.setAttribute("fejl", "Den angivne kode er forkert");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
