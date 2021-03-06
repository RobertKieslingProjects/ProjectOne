package com.revature.rkiesling.ets;

import com.revature.rkiesling.ets.User;
import com.revature.rkiesling.ets.Role;
import com.revature.rkiesling.ets.UserNotFoundException;
import com.revature.rkiesling.ets.util.UserTable;
import com.revature.rkiesling.ets.util.JDBCConnection;

import javax.servlet.ServletException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class UserDAO implements UserTable, Role {
    static void addUser (User u) {

        Connection c = JDBCConnection.getJDBCConnection ();
        Statement s = null;

        String sql = "insert into "
            + UserTable.tableName
            + "(firstname, lastname, userid, password, ssn, role, email) "
            + "values ("
            + "\'" + u.firstName () + "',"
            + "\'" + u.lastName () + "',"
            + "\'" + u.userid () + "',"
            + "\'" + u.password () + "',"
            + "\'" + u.SSN () + "',"
            + u.role () + ","
	    + "\'" + u.email () + "')";
        try {
            s = c.createStatement ();
            Integer nrows = s.executeUpdate (sql);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            JDBCConnection.closeAll (c, s);
        }
        
    }

    public User getUser (String userid, String password) {
        Connection c = JDBCConnection.getJDBCConnection ();
        User u = null;
        ResultSet r = null;
        PreparedStatement p = null;
        String sql = "select * from "
            + UserTable.tableName
            + " where userid = "
            + "'" + userid + "'"
            + " and password = "
            + "'" + password + "'";
        try {
            p = c.prepareStatement (sql);
            r = p.executeQuery ();
            if (r.next ()) {
                if (password.equals (r.getString ("password"))) {
                    u = new User (r.getString ("firstname"),
                                  r.getString ("lastname"),
                                  r.getString ("userid"),
                                  r.getString ("password"),
                                  r.getString ("SSN"),
                                  r.getString ("email"),
                                  r.getInt ("role"));
                }
            }
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            JDBCConnection.closeAll (c, p, r);
        }
        return u;
            
    }

    public User getUser (String userid) {
	Connection c = JDBCConnection.getJDBCConnection ();
	User u = null;
	ResultSet r = null;
	PreparedStatement p = null;
	String sql = "select * from "
	    + UserTable.tableName
	    + " where userid = "
	    + "'" + userid + "'";
	try {
	    p = c.prepareStatement (sql);
	    r = p.executeQuery ();
	    if (r.next ()) {
		u = new User (r.getString ("firstname"),
			      r.getString ("lastname"),
			      r.getString ("userid"),
			      r.getString ("password"),
			      r.getString ("SSN"),
			      r.getString ("email"),
			      r.getInt ("role"));
	    }
	} catch (SQLException e) {
	    System.out.println (e.getMessage ());
	} finally {
	    JDBCConnection.closeAll (c, p, r);
	}
	return u;
    }

    public static void updateUserInfo (String olduserid,
				       String newuserid,
				       String newemail) {
	Connection c = JDBCConnection.getJDBCConnection ();
	Statement s = null;
	String sql = "update "
	    + UserTable.tableName
	    + " set userid = '" + newuserid + "', "
	    + " email = '" + newemail + "' "
	    + " where userid = "
	    + "'" + olduserid + "'";
	try {
	    s = c.createStatement ();
	    s.executeUpdate (sql);
	} catch (SQLException e) {
	    System.out.println (e.getMessage ());
	} finally {
	    JDBCConnection.closeAll (c, s);
	}
	    
    }

}
