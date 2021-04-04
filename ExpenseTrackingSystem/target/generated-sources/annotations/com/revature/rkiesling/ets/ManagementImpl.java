package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.InvoiceDAO;
import com.revature.rkiesling.ets.util.InvoiceTable;
import com.revature.rkiesling.ets.util.WebPage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagementImpl
 */
public class ManagementImpl extends HttpServlet implements InvoiceTable, WebPage {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagementImpl() {
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
        response.setContentType ("text/html");
        PrintWriter out = response.getWriter ();
	InvoiceDAO dao = new InvoiceDAO ();
	String tgtUser = (String)request.getParameter("userselection");
	Integer approved = InvoiceTable.STATUS_BOTH;
	String approvedStrPending = null;
	String approvedStrApproved = null;
	if ((approvedStrPending = (String)request.getParameter ("pending")) != null) {
	    if ((approvedStrApproved = (String)request.getParameter ("resolved")) != null) {
		approved = InvoiceTable.STATUS_BOTH;
	    } else {
		approved = InvoiceTable.STATUS_PENDING_APPROVAL;
	    }
	} else {
	    // approveStringPending == null
	    if ((approvedStrApproved = (String)request.getParameter ("resolved")) != null) {
		approved = InvoiceTable.STATUS_APPROVED;
	    }
	}
        out.append (WebPage.reviewHeading ());
	out.append (dao.reviewInvoices (tgtUser, approved));
    }

}
