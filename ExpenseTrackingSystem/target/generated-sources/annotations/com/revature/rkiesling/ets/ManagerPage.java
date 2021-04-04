package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Manager
 */
public class ManagerPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerPage() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String makeWebPage (String firstName, String lastName,
                                String userid, String base_url) {
        String s = WebPage.pageHeading ("Expense Management");
        // For a more readable, similar version, see index.jsp
        s += "<h2>Expense Management</h2>";
	if (firstName == null) {
	    s += "<h5>Continue Reviewing Invoices</h5>";
	} else {
	    s += "<h5>Welcome, <b>" + firstName + " " + lastName + "</b></h5>";
	}
        s += WebPage.manageForm;
        s += "<a href=\"" + base_url + "\" class=\"text-light bg-secondary\"><b>Sign Out.<b></a>";
        s += WebPage.pageFooting ();
        return s;
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
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        StringBuffer URL = request.getRequestURL();
        String baseURL = URL.toString ().substring (0, URL.toString ().length () - 7); // Length of /Manage	

        String firstName = "";
        if ((firstName = (String)request.getAttribute ("firstName")) == null) {
            firstName = (String)request.getParameter ("firstName");
        }
        String lastName = "";
        if ((lastName = (String)request.getAttribute ("lastName")) == null) {
            lastName = (String)request.getParameter ("lastName");
        }
        String userid = "";
        if ((userid = (String)request.getAttribute ("userid")) == null) {
            userid = (String)request.getParameter ("userid");
        }
        out.append(makeWebPage (firstName, lastName, userid, baseURL));
        
    }

}
