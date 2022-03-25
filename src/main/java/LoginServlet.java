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
            request.setAttribute("fejlTilIndex", "kontoen fandtes ikke");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if(!konto.getKode().equals(kode)){
            request.setAttribute("fejlTilIndex", "Den angivne kode er forkert");
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }
        //Her når vi hen hvis det lykkes at logge ind

        HttpSession session = request.getSession();
        session.setAttribute("konto", konto);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);


    }
    //TODO nedlæg konto
    //TODO fælleskonto
    //TODO stille krav til passwordet

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("newName");

        Map<String, Konto> kontoMap = (Map<String, Konto>) getServletContext().getAttribute("konti");

        if(kontoMap.containsKey(name)){
            request.setAttribute("fejlTilIndex", "Navnet " + name + " er taget, prøv et andet");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        String pass1 = request.getParameter("pass1");
        String pass2 = request.getParameter("pass2");

        if (!pass1.equals(pass2))
        {
            request.setAttribute("fejlTilIndex", "Kodeordene er ikke ens");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        Konto konto = new Konto(name,pass1,0);
        kontoMap.put(konto.getNavn(),konto);

        request.getRequestDispatcher("index.jsp").forward(request, response);



    }
}
