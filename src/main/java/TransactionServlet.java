import Domæneobjekter.Konto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TransactionServlet", value = "/TransactionServlet")
public class TransactionServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int beløb = Integer.parseInt(request.getParameter("beløb"));

        Konto konto = (Konto) request.getSession().getAttribute("konto");


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
        int beløb = Integer.parseInt(request.getParameter("beløbet"));

        Konto konto = (Konto) request.getSession().getAttribute("konto");


        String message = "";

        if (beløb < 0)
        {
            message = "Du kan ikke indsætte et negativit beløb";
        }
        konto.deposit(beløb);

        request.setAttribute("message", message);

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request, response);


    }
}
