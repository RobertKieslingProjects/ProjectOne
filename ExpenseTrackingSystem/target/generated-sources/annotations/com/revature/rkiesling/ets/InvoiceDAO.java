package com.revature.rkiesling.ets;

import java.text.DecimalFormat;

import com.revature.rkiesling.ets.Invoice;
import com.revature.rkiesling.ets.util.InvoiceTable;
import com.revature.rkiesling.ets.util.WebPage;
import com.revature.rkiesling.ets.util.JDBCConnection;

import javax.servlet.ServletException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class InvoiceDAO implements InvoiceTable, WebPage {

    public void addClaim (Invoice i) {
        Connection c = JDBCConnection.getJDBCConnection ();
        Statement s = null;

        String sql = "insert into "
            + InvoiceTable.tableName
            + "(userid, amount, vendor, invoiceno, approved, description) "
            + "values ("
            + "\'" + i.userid () + "',"
            + i.amount () + ","
            + "\'" + i.vendor () + "',"
            + "\'" + i.invoiceno () + "',"
            + InvoiceTable.STATUS_PENDING_APPROVAL + ","
            + "\'" + i.description () + "')";
        try {
            s = c.createStatement ();
            Integer nrows = s.executeUpdate (sql);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            JDBCConnection.closeAll (c, s);
        }
        
    }

    public String listInvoices (String userid, Integer approved) {
        Connection c = JDBCConnection.getJDBCConnection ();
        Statement s = null;
        ResultSet r = null;
        String sOut = "";
        String sDate = "";
        String sTime = "";
        Float amt = 0.0f;
        DecimalFormat fmt = new DecimalFormat ("#.00");
        String sVendor = "";
        String sInvoiceNo = "";
        String sDesc = "";
        int extra4break;
        String sql = "select * from " + InvoiceTable.tableName +
            " where userid = '" + userid + "' and approved = " + approved;
        try {
            s = c.createStatement ();
            r = s.executeQuery (sql);
            while (r.next ()) {
                sTime = r.getString ("filedate").substring (12, 19);
                sDate = WebPage.noBreak (r.getString ("filedate").substring (0, 10));
                sDate += "&nbsp;" + sTime;
                sOut += "<samp>" + WebPage.padStr(sDate, 37);
                amt = r.getFloat ("amount");
                sOut += WebPage.padStr (fmt.format (amt), 10);
                sVendor = r.getString ("vendor");
                // All of this processing is to make sure that spaces and hyphens
                // don't cause lines to break.
                if ((extra4break = WebPage.extraBreak (sVendor)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sVendor), 15 + extra4break);
                } else {
                    sOut += WebPage.padStr (sVendor, 15);
                }
                sInvoiceNo = r.getString ("invoiceno");
                if ((extra4break = WebPage.extraBreak (sInvoiceNo)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sInvoiceNo), 15 + extra4break);
                } else {
                    sOut += WebPage.padStr (sInvoiceNo, 15);
                }
                sDesc = r.getString ("description");
                if ((extra4break = WebPage.extraBreak (sDesc)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sDesc), 30 + extra4break);
                } else {
                    sOut += WebPage.padStr (sDesc, 30);
                }
                sOut += "</samp><br>";
            }
        } catch (SQLException e) {
        } finally {
            JDBCConnection.closeAll (c, s, r);
        }
        return sOut;
    }

    private String approveCheckForm (String dateStampKey) {
	String s;
	s = "</samp><br>"
	    + "<div class=\"form-group border border-dark bg-primary text-gray\">"
	    + "  <label for=\"check\"><samp>Approve</samp></label>"
	    + "  <input type=\"checkbox\" style=\"color: blue;\" name=\"" + dateStampKey +
	    "\" value=\"" + dateStampKey + "\"></div><hr>";
	return s;
    }

    public String reviewInvoices (String userid, Integer approved) {
        Connection c = JDBCConnection.getJDBCConnection ();
        Statement s = null;
        ResultSet r = null;
        String sOut = "";
        String sUserID = "";
        String sDate = "";
        String sDateKey = "";
        String sTime = "";
        Float amt = 0.0f;
        DecimalFormat fmt = new DecimalFormat ("#.00");
        String sVendor = "";
        String sInvoiceNo = "";
        String sDesc = "";
        String sql = null;
        int extra4break;
	int recApproved = 0;
        if (approved == InvoiceTable.STATUS_BOTH) {
            if (userid.length () == 0) {
                sql = "select * from " + InvoiceTable.tableName;
            } else {
                sql = "select * from " + InvoiceTable.tableName +
                    " where userid = '" + userid + "'";
            }
        } else {
            if (userid.length () == 0) {
                sql = "select * from " + InvoiceTable.tableName +
                    " where approved = " + approved;
            } else {
                sql = "select * from " + InvoiceTable.tableName +
                    " where userid = '" + userid + "' and approved = " + approved;
            }
        }
        try {
            s = c.createStatement ();
            r = s.executeQuery (sql);
            sOut = "<form action=\"Approve\" method=\"Post\">";
            while (r.next ()) {
                sUserID = r.getString ("userid");
                sOut += "<samp>" + WebPage.padStr (sUserID, 20);
                sTime = r.getString ("filedate").substring (12, 19);
                sDate = WebPage.noBreak (r.getString ("filedate").substring (0, 10));
                sDate += "&nbsp;" + sTime;
                // here use datestamp exacly as it appears in the data
                sDateKey = sUserID + "~" + r.getString ("filedate"); 
                sOut += "<samp>"
                    + WebPage.padStr(sDate, 37);
                amt = r.getFloat ("amount");
                sOut += WebPage.padStr (fmt.format (amt), 10);
                sVendor = r.getString ("vendor");
                // All of this processing is to make sure that spaces and hyphens
                // don't cause lines to break.
                if ((extra4break = WebPage.extraBreak (sVendor)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sVendor), 15 + extra4break);
                } else {
                    sOut += WebPage.padStr (sVendor, 15);
                }
                sInvoiceNo = r.getString ("invoiceno");
                if ((extra4break = WebPage.extraBreak (sInvoiceNo)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sInvoiceNo), 15 + extra4break);
                } else {
                    sOut += WebPage.padStr (sInvoiceNo, 15);
                }
                sDesc = r.getString ("description");
                if ((extra4break = WebPage.extraBreak (sDesc)) > 0) {
                    sOut += WebPage.padStr (WebPage.noBreak (sDesc), 30 + extra4break);
                } else {
                    sOut += WebPage.padStr (sDesc, 30);
                }
                switch (approved)
                    {
                    case InvoiceTable.STATUS_PENDING_APPROVAL:
			sOut += approveCheckForm (sDateKey);
                        break;
                    case InvoiceTable.STATUS_APPROVED:
                        sOut += "</samp><br>"
                            + "  <label <samp><b>Approved</b></samp></label></div><hr>";
                        break;
                    case InvoiceTable.STATUS_BOTH:
			recApproved = r.getInt ("approved");
			switch (recApproved) {
			case InvoiceTable.STATUS_PENDING_APPROVAL:
			    sOut += approveCheckForm (sDateKey);
			    break;
			case InvoiceTable.STATUS_APPROVED:
			    sOut += "</samp><br>"
				+ "  <label <samp><b>Approved</b></samp></label></div><hr>";
			    break;
			}
                        break;
                    }
            }
	    if (approved == InvoiceTable.STATUS_APPROVED) {
		sOut += "<input type=\"submit\" value=\"Return to Query Page\">";
	    } else {
		sOut += "<input type=\"submit\" value=\"Submit Approvals\">";
	    }
            sOut += "</form>";
        } catch (SQLException e) {
        } finally {
            JDBCConnection.closeAll (c, s, r);
        }
        return sOut;
    }

    public void approveClaim (String userid, String datestamp) {
        Connection c = JDBCConnection.getJDBCConnection ();
        Statement s = null;

        String sql = "update "
            + InvoiceTable.tableName
            + " set approved = " + InvoiceTable.STATUS_APPROVED + " where "
            + "userid = '" + userid + "' and filedate = '" + datestamp + "'";
        try {
            s = c.createStatement ();
            Integer nrows = s.executeUpdate (sql);
        } catch (SQLException e) {
            System.out.println (e.getMessage ());
        } finally {
            JDBCConnection.closeAll (c, s);
        }
        
    }

}
