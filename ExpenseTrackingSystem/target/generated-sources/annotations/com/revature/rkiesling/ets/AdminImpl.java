package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminImpl
 */
public class AdminImpl extends HttpServlet implements WebPage {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImpl() {
        super();
        // TODO Auto-generated constructor stub
    }

    private String makeWebPage (String title) {
        String s = WebPage.pageHeading (title);
        s += "<h2>Administration</h2>";
        s += WebPage.pageFooting ();
        return s;
    }
    private String makeWebPage (String title, String firstName, String lastName, String dbinit,
				String userAddedSuccess, String base_url) {
        String s = WebPage.pageHeading (title);

        s += "<h2>Administration</h2>";

	if (dbinit != null) {
	    if (dbinit.equals("true")) {
		s += "<h6>Database initialization successful.</h6>";
	    }
	} else if (userAddedSuccess != null) {
	    s += "<h6>User added successfully.</h6>";
	} else if (firstName != null && lastName != null) {
	    s += "<h5>Welcome, <b>" + firstName + " " + lastName + "</b></h5>";
	}

        s += WebPage.addUserForm;
        s += "<a href=\"" + base_url + "\" class=\"text-light bg-secondary\"><b>Finished Adding Users - Return to the Login Page.<b></a>";
        s += WebPage.pageFooting ();
        return s;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        out.append(makeWebPage ("Expense System Adinistration"));
    }
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
        StringBuffer URL = request.getRequestURL();
        String baseURL = URL.toString ().substring (0, URL.toString ().length () - 13); // Length of /ExpenseAdmin
        out.append(makeWebPage ("Expense System Adinistration",
                                (String)request.getAttribute ("firstName"),
                                (String)request.getAttribute ("lastName"),
                                (String)request.getAttribute ("dbinit"),
                                (String)request.getAttribute ("userAddedSuccess"),
                                baseURL));
    }
}
