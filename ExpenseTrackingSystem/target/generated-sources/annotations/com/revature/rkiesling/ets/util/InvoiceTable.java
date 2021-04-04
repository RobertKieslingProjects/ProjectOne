package com.revature.rkiesling.ets.util;

import java.util.Arrays;
import java.util.ArrayList;

public interface InvoiceTable {
    public static final String schemaName = "expenses";
    public static final String tableName = "expenses.invoices";

    public static final ArrayList<String> colNames =
        new ArrayList <> (Arrays.asList 
                          ("userid",
                           "amount",
                           "vendor",
                           "invoiceno",
                           "approved", 
                           "description"));
    // Used when we construct the query to create the
    // table.
    public static final ArrayList<String> colDefs =
        new ArrayList <> (Arrays.asList
                          ("userid varchar (128) not null,",
                           "filedate timestamp default current_timestamp,",
                           "amount money not null,",
                           "vendor varchar (128) not null,",
                           "invoiceno varchar (128) not null,",
                           "approved int,",
                           "description varchar (200) not null)"));

    public static final int STATUS_PENDING_APPROVAL = 0;
    public static final int STATUS_APPROVED = 1;
    // superposition
    public static final int STATUS_BOTH = 2;
}
