package com.revature.rkiesling.ets.util;

import com.revature.rkiesling.ets.Role;
import com.revature.rkiesling.ets.util.UserTable;
import com.revature.rkiesling.ets.util.InvoiceTable;
import com.revature.rkiesling.ets.util.JDBCConnection;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil implements UserTable, InvoiceTable {

    public static boolean haveSchema () throws SQLException {
        Connection c = null;
        PreparedStatement p = null;
        ResultSet r = null;
        boolean returnVal = false;
        String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
        c = JDBCConnection.getJDBCConnection ();
        p = c.prepareStatement(sql);
        p.setString(1, UserTable.schemaName);
        r = p.executeQuery ();
        if (r.next ()) {
            returnVal = true;
        } else {
            returnVal = false;
        }
        JDBCConnection.closeAll (c, p, r);
        return returnVal;
    }

    public static String makeSchema () {
        Connection c = null;
        String sql = "SELECT schema_name FROM information_schema.schemata WHERE schema_name = ?";
        PreparedStatement p = null;
        ResultSet r = null;
        String out = "";
        try {
            c = JDBCConnection.getJDBCConnection ();
            p = c.prepareStatement(sql);
            p.setString(1, UserTable.schemaName);
            r = p.executeQuery ();
            if (!r.next ()) {
                out = "Schema, \"" + UserTable.schemaName +
                    ",\" not found - creating...<br>";
                sql = "create schema " + UserTable.schemaName;
                p = c.prepareStatement (sql);
                p.executeUpdate ();
            }
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
            out += " " + e.getMessage () + "<br>";
        } finally {
            JDBCConnection.closeAll (c, p, r);
        }
        return out;
    }

    public static String makeTables () {
        //
        // Records its operations in the console
        //
        String out = "";
        Connection c = null;
        String sqlUser = "drop table if exists " + UserTable.tableName;
        String sqlInvoice = "drop table if exists " + InvoiceTable.tableName;
        PreparedStatement p = null;
        StringBuffer query = new StringBuffer (1024);

        try {
            c = JDBCConnection.getJDBCConnection ();
                        
            p = c.prepareStatement(sqlUser);
            try {
                p.executeUpdate ();
                System.out.println ("Removing old user table if needed.");
            } catch (SQLException e) {
                System.out.println ("e.getMessage ()");
            }

            //
            // create table SQL: see UserTable.java.
            //
                
            query.insert(0, "create table " +
                         UserTable.tableName + " (");
            for (String spec: UserTable.colDefs) {
                query.append(spec);
            }
            p = c.prepareStatement(query.toString());
            try {
                p.executeUpdate ();
                System.out.println ("Created User table.");
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }

            //
            //  Now create the invoice table
            //
            p = c.prepareStatement(sqlInvoice);
            try {
                p.executeUpdate ();
                System.out.println ("Removing old invoice table if needed.");
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }

	    // Delete the previous query
	    query.delete (0, query.length ());  

            query.insert(0, "create table " +
                         InvoiceTable.tableName + " (");
            for (String spec: InvoiceTable.colDefs) {
                query.append(spec);
            }
            p = c.prepareStatement(query.toString());
            try {
                p.executeUpdate ();
                System.out.println ("Created Invoice table.");
            } catch (SQLException e) {
                System.out.println (e.getMessage ());
            }

        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        }
        JDBCConnection.closeAll (c, p);
        return out;
    }

    public static String createAdminUser () {

        Connection c = null;
        PreparedStatement p = null;
        String out = "";

        try {

            c = JDBCConnection.getJDBCConnection ();

            String sql = "insert into " + UserTable.tableName +
                " (firstname, lastname, userid, password, ssn, role)" +
                " values ('adminFirstName', 'adminLastName', 'admin', " +
                "'admin', '111-11-1111', " + Role.ROLE_ADMIN + ")";
                                                                        
            p = c.prepareStatement(sql);

            Integer nUpdatedRows = p.executeUpdate ();
            if (nUpdatedRows == 1) {
                out += "Created admin user...<br>";
            } else {
                out += "Failed to create admin user... <br>";
            }
        } catch (SQLException e) {
            out += e.getMessage () + ".<br>"; 
        } finally {
            JDBCConnection.closeAll (c, p);
        }
        return out;
    }
                
}
