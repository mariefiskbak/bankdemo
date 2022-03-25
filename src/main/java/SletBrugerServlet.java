import Domæneobjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "SletBrugerServlet", value = "/SletBrugerServlet")
public class SletBrugerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        String name1 = request.getParameter("brugernavn");

        if (kontoMap.containsKey(name1)) {
            kontoMap.remove(name1);
        }
        if (!kontoMap.containsKey(name1)) {
            request.setAttribute("fejlTilIndex", "Konto findes ikke");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
