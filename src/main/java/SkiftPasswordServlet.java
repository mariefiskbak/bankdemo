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
        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");
        kontoMap.()

                //vi er i et sessionscope. Brugernavnet må ligge et sted. Vi skal hente det, så vi kan overskrive passwordet

    }
}
