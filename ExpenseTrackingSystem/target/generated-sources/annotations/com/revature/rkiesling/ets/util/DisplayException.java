package com.revature.rkiesling.ets.util;

import com.revature.rkiesling.ets.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayException
 */
public class DisplayException extends HttpServlet implements WebPage {
        private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayException() {
        super();
        // TODO Auto-generated constructor stub
    }

        /**
         * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
         */
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType ("text/html");
            PrintWriter out = response.getWriter ();
            StringWriter errString = new StringWriter ();
            PrintWriter errPrint = new PrintWriter (errString);
            Throwable e = (Throwable)request.getAttribute ("javax.servlet.error.exception");
            e.printStackTrace (errPrint);
            out.append (WebPage.errorPageHeading("Internal Error"));
            out.append ("<h2><b>Internal Error</b></h2><h2>" + e.getMessage () + "</h2>" + "<pre class=\"example-element\">" +
                        errString.toString () + "</pre>");
        }

}
