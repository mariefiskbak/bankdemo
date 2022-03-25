import Domæneobjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransactionServlet", value = "/TransactionServlet")
public class TransactionServlet extends HttpServlet
{
    //TODO overføre mellem konti
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int beløb = Integer.parseInt(request.getParameter("value"));

        Konto konto = (Konto) request.getSession().getAttribute("konto");

//TODO fejlbehandling hvis man er logget ud og prøver at hæve
        String message = "";

        if (beløb > konto.getSaldo())
        {
            message = "Så mange penge har du ikke";
        }

        if (beløb < 0)
        {
            message = "Du kan ikke hæve et negativt beløb";
        } else if (beløb < konto.getSaldo())
        {
            message = "Du har hævet " + beløb + " kr";
        }

        request.setAttribute("message", message);
        konto.withdraw(beløb);
        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int beløb = Integer.parseInt(request.getParameter("value"));

        Konto konto = (Konto) request.getSession().getAttribute("konto");


        String message = "";

        if (beløb < 0)
        {
            message = "Du kan ikke indsætte et negativit beløb";
        }

        try {
            konto.deposit(beløb);
        } catch (Exception e) {
            request.setAttribute("fejl", "Du er logget af, gå til forsiden for at logge ind");
            request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);
        } //TODO fejlhåndteringen virker ikke

        request.setAttribute("message", message);

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);


    }
}
