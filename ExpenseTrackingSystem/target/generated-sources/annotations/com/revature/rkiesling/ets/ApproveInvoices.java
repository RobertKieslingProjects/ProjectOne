package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.InvoiceDAO;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApproveInvoices
 */
public class ApproveInvoices extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveInvoices() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	doGet (request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
	InvoiceDAO dao = new InvoiceDAO ();

	// If the manager only reviewed approved requests, this list will
	// be empty.
	Enumeration paramNames = request.getParameterNames();

	while(paramNames.hasMoreElements()) {
	    String paramName = (String)paramNames.nextElement();
	    String value = request.getParameterValues(paramName)[0];

	    String keys[] = value.split ("~", value.length ());
	    dao.approveClaim (keys[0], keys[1]);
	}

        RequestDispatcher dispatcher = null;
	dispatcher = request.getRequestDispatcher ("/Manage");

	try {
	    dispatcher.forward (request, response);
	} catch (ServletException e) {
	    System.out.println (e.getMessage ());
	} catch (IOException e) {
	    System.out.println (e.getMessage ());
	}
	
    }

}
