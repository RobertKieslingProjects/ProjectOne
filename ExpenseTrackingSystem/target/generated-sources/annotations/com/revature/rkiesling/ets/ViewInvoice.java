package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.util.WebPage;
import com.revature.rkiesling.ets.InvoiceDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewInvoice
 */
public class ViewInvoice extends HttpServlet implements WebPage {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewInvoice() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        doPost (request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
	InvoiceDAO dao = new InvoiceDAO ();
	String userid = (String)request.getParameter ("userid");
	String approved = (String)request.getParameter ("approved");
	String firstName = (String)request.getParameter ("firstName");
	String lastName = (String)request.getParameter ("lastName");
	response.setContentType ("text/html");
	PrintWriter out = response.getWriter ();
	out.append (WebPage.viewHeading (userid, approved));
	out.append (dao.listInvoices (userid, Integer.parseInt(approved)));
	out.append ("<form action=\"Expenses\" method=\"Post\">");
	out.append ("<button type\"submit\">Return to Previous Page</button>");
	out.append ("<input type=\"hidden\" name=\"firstName\" value=\"" + firstName + "\">");
	out.append ("<input type=\"hidden\" name=\"lastName\" value=\"" + lastName + "\">");
	out.append ("<input type=\"hidden\" name=\"userid\" value=\"" + userid + "\">");
	out.append ("</form>");

    }

}
