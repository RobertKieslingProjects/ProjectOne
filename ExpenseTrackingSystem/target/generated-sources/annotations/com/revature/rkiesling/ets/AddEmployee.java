package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.User;
import com.revature.rkiesling.ets.UserDAO;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddEmployee
 */
public class AddEmployee extends HttpServlet implements Role {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEmployee() {
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
        String rolStr = request.getParameter ("role");
        Integer role = 0;
        if (rolStr.equals ("employee")) {
            role = Role.ROLE_EMPLOYEE;
        } else if (rolStr.equals ("manager")) {
            role = Role.ROLE_MANAGER;
        } else if (rolStr.equals ("admin")) {
            role = Role.ROLE_ADMIN;
        }
        User user = new User (request.getParameter ("firstname"),
                              request.getParameter ("lastname"),
                              request.getParameter ("userid"),
                              request.getParameter ("password"),
                              request.getParameter ("ssn"),
			      request.getParameter ("email"),
                              role);
        UserDAO.addUser (user);
        request.setAttribute ("userAddedSuccess", "true");
        RequestDispatcher dispatcher =
            request.getRequestDispatcher ("/ExpenseAdmin");
        dispatcher.forward (request, response);
    }

}
