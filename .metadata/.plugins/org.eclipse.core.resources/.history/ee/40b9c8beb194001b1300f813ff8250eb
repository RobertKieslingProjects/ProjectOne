package com.revature.rkiesling.project1.util;

import com.revature.rkiesling.project1.util.InvoiceTable;

public interface WebPage {
        
    String adminInputSize = "\"50\"";
    String roleSelectSize = "\"35\"";
    String formInputPad = "p-2";
    String classMonospace = "class=\"text-monospace\"";

    // If s1 contains spaces, you should replace the spaces with &nbsp;
    // (non-breakable space), unless you want a line to potentially
    // wrap there.  HOWEVER, make sure that you add 5 to the length
    // argument, because &nbsp; takes up 6 spaces, while a regular
    // space occupies - well 1 space.
    //
    // Intended to be used in <samp> etc. elements,
    // which don't display as much leading as <pre> content.
    //
    public static String padStr (String s1, Integer colWidth) {
        int i;
        String s2 = s1;
        for (i = s1.length (); i < colWidth; ++i) {
            s2 += "&nbsp;";
        }
        return s2;
    }

    public static String noBreak (String s1) {
        String s2 = "";
        Character c;
        for (int i = 0; i < s1.length (); ++i) {
            c = s1.charAt (i);
            if (Character.compare (c, ' ') == 0) {
                s2 += "&nbsp;";
            } else if (Character.compare (c, '-') == 0) {
                s2 += "&#8209;";  // non-breaking hyphen
            } else {
                s2 += s1.charAt (i);
            }
        }
        return s2;
    }

    public static int extraBreak (String s1) {
        int n = 0;
        Character c;
        for (int i = 0; i < s1.length (); ++i) {
            c = s1.charAt (i);
            if (Character.compare (c, ' ') == 0) {
                n += 5;
            } else if (Character.compare (c, '-') == 0) {
                n += 6;
            }
        }
        return n;
    }

    // The portion of the heading before the user-defined title
    static String heading1 = 
        "<!DOCTYPE html><html lang=\"en\"><head>\n" 
        + "<meta charser=\"utf-8\">\n"
        + "<meta name=\"viewport\" content=\"width=device-width, inititial-scale=1\">\n"
        + "<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl\" crossorigin=\"anonymous\">"
        + "<title>";

    static String addUserForm =
        "<div class=\"d-grid gap-3 p-2 border border-dark bg-primary text-gray\">" 
          + "<form action=\"AddEmployee\" method=\"POST\">"
            + "<h6>Add a user:</h6>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"First Name\" size=" + adminInputSize + "class=\"form-control\" name=\"firstname\" id=\"firstname\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Last Name\" size=" + adminInputSize + "class=\"form-control\" name=\"lastname\" id=\"lastname\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"SSN (xxx-xx-xxxx)\" size=" + adminInputSize + "class=\"form-control\" name=\"ssn\" id=\"ssn\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"User ID\" size=" + adminInputSize + "class=\"form-control\" name=\"userid\" id=\"userid\">"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Password\" type=\"password\" size=" + adminInputSize + "class=\"form-control\" name=\"password\" id=\"password\">"
            + "</div>"
            + "<br>"
            + "<div class=\"d-grid gap-3 " + formInputPad + "\">"
              + "<div class=\"border border-dark\">"
                  + "<div class=\"" + formInputPad + "\">"
                    + "<label for=\"role\" class=\"" + formInputPad + "\">Role...</label>"
                    + "<select placeholder=\"Role...\" class=\"custom-select\" name=\"role\" id=\"role\" multiple>"
                      + "<option value=\"admin\">Admin</option>"
                      + "<option value=\"employee\">Employee</option>"
                      + "<option value=\"manager\">Manager</option>"
                    + "</select>"
                  + "</div>"
              + "</div>"

              + "<div width=\"50%\" class=\"border border-dark " + formInputPad + "\">"
                + "<button type=\"submit\">Add User</button>"
              + "</div>"
            + "</div>"
          + "</form>"
        + "</div>";
    
        
    static String addClaimForm =
        "<div class=\"d-grid gap-3 p-2 border border-dark bg-primary text-gray\">" 
          + "<form action=\"AddClaim\" method=\"POST\">"
            + "<h6>Add a claim:</h6>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Your User ID\" size=" + adminInputSize + "class=\"form-control\" name=\"userid\" id=\"userid\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Amount (000.00)\" size=" + adminInputSize + "class=\"form-control\" name=\"amount\" id=\"amount\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Vendor\" size=" + adminInputSize + "class=\"form-control\" name=\"vendor\" id=\"vendor\">"
            + "</div>"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input placeholder=\"Invoice No.\" size=" + adminInputSize + "class=\"form-control\" name=\"invoiceno\" id=\"invoiceno\">"
            + "<div class=\"form-group mx-auto " + formInputPad + "\">"
              + "<input type=\"textarea\" placeholder=\"Description\" size=" + adminInputSize + "class=\"form-control\" name=\"description\" id=\"description\">"
            + "</div>"
            + "<br>"
              + "<div width=\"50%\" class=\"border border-dark " + formInputPad + "\">"
                + "<button type=\"submit\">Add Expense Claim</button>"
              + "</div>"
            + "</div>"
          + "</form>"
        + "</div>";
    
    public static String userInvoiceViewButtons (String userid, String firstName, String lastName) {
        String s =
            "<div class=\"d-grid gap-3 p-2 border border-dark bg-primary text-gray\">" 
            + "  <table><tr>"
            + "  <td>"
            + "  <form action=\"ViewInvoice\" method=\"POST\">"
            + "    <button type=\"submit\">View Pending Invoices</button>"
            + "    <input type=\"hidden\" name=\"userid\" value=\"" + userid + "\">"
            + "    <input type=\"hidden\" name=\"firstName\" value=\"" + firstName + "\">"
            + "    <input type=\"hidden\" name=\"lastName\" value=\"" + lastName + "\">"
            + "    <input type=\"hidden\" name=\"approved\" value=\"0\">"
            + "  </form>"
            + "  </td><td>"
            + "  <form action=\"ViewInvoice\" method=\"POST\">"
            + "    <button type=\"submit\">View Approved Invoices</button>"
            + "    <input type=\"hidden\" name=\"userid\" value=\"" + userid + "\">"
            + "    <input type=\"hidden\" name=\"firstName\" value=\"" + firstName + "\">"
            + "    <input type=\"hidden\" name=\"lastName\" value=\"" + lastName + "\">"
            + "    <input type=\"hidden\" name=\"approved\" value=\"1\">"
            + "  </form>"
            + "  </td></table>"
            + "</div>";
            
        return s;
    }

    static String manageForm =
        "<div class=\"d-grid gap-3 p-2 border border-dark bg-primary text-gray\">" 
        + "<form action=\"Review\" method=\"POST\">"
        + "  <h6>Review Invoices By</h6>"
        + "    <div class=\"border border-dark gap-6 p-2\">"
        + "      <label for=\"pending\"><b>Pending Requests</b></label>"
        + "      <input type=\"checkbox\" id=\"pending\" name=\"pending\" value=\"pending\"><br>"
        + "      <label for=\"resolved\"><b>Resolved Requests</b></label>"
        + "      <input type=\"checkbox\" id=\"resolved\" name=\"resolved\" value=\"resolved\"><br>"
        + "      <div class=\"gap-3 pt-2 pb-2\">"
        + "        <input type=\"input\" placeholder=\"User ID (Leave blank to view all users.)\" class=\"form-control\" id=\"userselection\" name=\"userselection\">"
        + "      </div>"
        + "    </div>"
        + "  <br>"
        + "  <div width=\"50%\" class=\"border border-dark p-2 \">"
        + "    <button type=\"submit\">Query Invoices</button>"
        + "  </div>"
        + "</form>"
        + "</div>";
    

    public static String viewHeading (String userid, String approved) {
        String s = "";
        if (Integer.parseInt (approved) == InvoiceTable.STATUS_PENDING_APPROVAL) {
            s += "<h2>Pending Invoices for <font " + classMonospace + ">" + userid + "</font></h2>";
        } else if (Integer.parseInt (approved) == InvoiceTable.STATUS_APPROVED) {
            s += "<h2>Approved Invoices for <font " + classMonospace + ">" + userid + "</font></h2>";
        }
        s += "<font " + classMonospace + ">";
        s += "<samp>" + padStr ("Date&nbsp;Filed", 25) + padStr ("Amount", 10) + padStr ("Vendor", 15) +
            padStr ("Invoice&nbsp;No.", 20) + padStr ("Description", 30) + "</samp>";
        s += "<hr class=\"my-1\">";
        return s;
    }

    public static String reviewHeading () {
        String s = "";
        s += "<html><body style=\"background: #888; color: white\"><font " + classMonospace + ">";
        s += "<samp>" + padStr ("User&nbsp;ID", 25) + padStr ("Date&nbsp;Filed", 25) + padStr ("Amount", 10) + padStr ("Vendor", 15) +
            padStr ("Invoice&nbsp;No.", 20) + padStr ("Description", 30) + "</samp>";
        s += "<hr class=\"my-1\">";
        return s;
    }

    // Refer to the bootstrap documentation, https://getbootstrap.com,
    // for its bgStyle and textColor definitions.
    public static String pageHeadingInternal (String title, String bgStyle,
                                              String textColor) {
        String headingString = heading1;
        headingString += title;
        headingString += "</title></head><body class=\"p-3 mb-2 ";
        headingString += bgStyle + " " + textColor + "\">";
        return headingString;
    }
    public static String pageHeading (String title) {
        return pageHeadingInternal (title, "bg-secondary", "text-white");
    }
    public static String errorPageHeading (String title) {
        return pageHeadingInternal (title, "bg-info", "text-black");
    }
    
    public static String pageFooting () {
        String footingString ="<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0\" crossorigin=\"anonymous\"></script>";

        footingString += "<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.6.0/dist/umd/popper.min.js\" integrity=\"sha384-KsvD1yqQ1/1+IA7gi3P0tyJcT3vR+NdBTt13hSJ2lnve8agRGXTTyNaBYmCR/Nwi\" crossorigin=\"anonymous\"></script>";
        footingString += "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.min.js\" integrity=\"sha384-nsg8ua9HAw1y0W1btsyWgBklPnCUAFLuTMS2G72MMONqmOymq585AcH49TLBQObG\" crossorigin=\"anonymous\"></script>";
        footingString += "</body></html>";
        return footingString;
    }
}
