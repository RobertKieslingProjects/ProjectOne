package com.revature.rkiesling.ets.util;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.postgresql.Driver;

public class JDBCConnection {
        
    public static void registerPostGresqlDriver () throws SQLException {
        /* 
         * This should be called from Login.init ()
         */
        try {
                DriverManager.registerDriver(new Driver ());  
        } catch (SQLException e) {
                System.out.println (e.getMessage ());
                throw e;
        }
    }
                
    public static Connection getJDBCConnection () {
        /* 
         * Connect to the DBMS set in the 
         *  following environment variables:
         *  
         *    db_user
         *    db_password
         *    db_url
         */
        String username = System.getenv("db_user");
        String password = System.getenv("db_password");
        String url = System.getenv("db_url");

        Connection con = null;

        try {
            DriverManager.registerDriver(new Driver ());
            con = DriverManager.getConnection
                (url, username, password);
            con.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }       
        return con;
    }   
        
    public static void closeAll (Connection c) {
        if (c != null) {
            try { 
                c.close(); 
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
    }

    public static void closeAll (Connection c,
                                 Statement s) {
        if (c != null) {
            try { 
                c.close(); 
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (s != null) {
            try {
                s.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
    }

    public static void closeAll (Connection c,
                                 PreparedStatement p) {
        if (c != null) {
            try { 
                c.close(); 
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (p != null) {
            try {
                p.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
    }

    public static void closeAll (Connection c,
                                 Statement s, ResultSet r) {
        if (c != null) {
            try { 
                c.close(); 
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (s != null) {
            try {
                s.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (r != null) {
            try {
                r.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
    }
    public static void closeAll (Connection c,
                                 PreparedStatement p, ResultSet r) {
        if (c != null) {
            try { 
                c.close(); 
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (p != null) {
            try {
                p.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
        if (r != null) {
            try {
                r.close ();
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }
        }
    }

}       
        
