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
        String beløb = request.getParameter("beløb");

        Konto konto = (Konto) request.getSession().getAttribute("konto");

        int i = Integer.parseInt(beløb);    // mere læsbar

        konto.withdraw(i);

        request.getRequestDispatcher("WEB-INF/BrugerSide.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }
}
