package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.Invoice;
import com.revature.rkiesling.ets.InvoiceDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddClaim
 */
public class AddClaim extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddClaim() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
											   IOException {
	    response.setContentType ("text/html");
	    Invoice i = new Invoice (request.getParameter ("userid"),
				     Float.parseFloat (request.getParameter ("amount")),
				     request.getParameter ("vendor"),
				     request.getParameter ("invoiceno"),
				     request.getParameter ("description"));
	    InvoiceDAO dao = new InvoiceDAO ();
	    dao.addClaim (i);
	    RequestDispatcher dispatcher =
		request.getRequestDispatcher ("/Expenses");
	    dispatcher.forward (request, response);
	}

}
