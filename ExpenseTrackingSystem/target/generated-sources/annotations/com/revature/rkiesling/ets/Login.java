package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.Role;
import com.revature.rkiesling.ets.User;
import com.revature.rkiesling.ets.UserDAO;
import com.revature.rkiesling.ets.UserNotFoundException;
import com.revature.rkiesling.ets.util.DBUtil;
import com.revature.rkiesling.ets.util.JDBCConnection;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.SQLException;

public class Login extends HttpServlet implements Role {
        private static final long serialVersionUID = 1L;
       
        public void init() throws ServletException {
                try {
                    JDBCConnection.registerPostGresqlDriver ();
                } catch (SQLException e) {
                    System.out.println (e.getMessage ());
                    throw new ServletException (e);
                }
        }
        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

    private void roleDispatch (User u, HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = null;
	request.setAttribute ("firstName", u.firstName ());
	request.setAttribute ("lastName", u.lastName ());
	request.setAttribute ("userid", u.userid ());

	switch (u.role ()) {
        case Role.ROLE_ADMIN:
            dispatcher = request.getRequestDispatcher ("/ExpenseAdmin");
            try {
                dispatcher.forward (request, response);
            } catch (ServletException e) {
                System.out.println (e.getMessage ());
            } catch (IOException e) {
                System.out.println (e.getMessage ());
            }
            break;
        case Role.ROLE_EMPLOYEE:
            dispatcher = request.getRequestDispatcher ("/Expenses");
            try {
                dispatcher.forward (request, response);
            } catch (ServletException e) {
                System.out.println (e.getMessage ());
            } catch (IOException e) {
                System.out.println (e.getMessage ());
            }
            break;
        case Role.ROLE_MANAGER:
            dispatcher = request.getRequestDispatcher ("/Manage");
            try {
                dispatcher.forward (request, response);
            } catch (ServletException e) {
                System.out.println (e.getMessage ());
            } catch (IOException e) {
                System.out.println (e.getMessage ());
            }
            break;
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                
                response.setContentType ("text/html");
                PrintWriter out = response.getWriter ();
                User u = null;
                UserDAO dao = new UserDAO ();
                // Check whether we have a database
                try {
                    if (!DBUtil.haveSchema ()) {
                        // If not, create databases
                        // and transfer to the add
                        // user page.
                        DBUtil.makeSchema ();
                        DBUtil.makeTables ();
                        DBUtil.createAdminUser ();
                        RequestDispatcher dispatcher =
                        request.getRequestDispatcher ("/ExpenseAdmin");
			request.setAttribute ("firstName", "adminFirstName");
                        request.setAttribute ("dbinit", "true");
                        request.setAttribute ("lastName", "adminLastName");
                        dispatcher.forward (request, response);
                    } else {
                        String userid = (String)request.getParameter ("userid");
                        String password = (String)request.getParameter ("password");
                        if ((u = dao.getUser (userid, password)) == null) {
                            StringBuffer URL = request.getRequestURL();
                            // This is so the server adds on the index.[html|jsp]
                            String baseurl = URL.substring(0, URL.length () - 6); // "/Login" servlet path length
                            out.append ("<html><body>");
                            out.append ("Invalid user ID or password.<br>");
                            out.append ("<a href=\"" + baseurl + "\">Retry</a>");
                            out.append ("</body></html>");
                        } else {
                            roleDispatch (u, request, response);
                        }
                    }
                } catch (SQLException e) {
                    throw new ServletException (e);
                }
        }
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet (request, response);
    }

}
