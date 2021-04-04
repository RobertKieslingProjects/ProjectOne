# Expense Tracking Project - Installation and Startup

The program uses JDBC to make a connection to the database that stores
the user and invoice information.  It uses the values of the following
environment variables to provide login information.

<pre>
db_user
db_password
db_url
</pre>

These should be set in the run configuration of the server (probably Tomcat).
The db_url value shoud be a valid JDBC location, for example:

<pre>
jdbc:postgresql://127.0.0.1:5432/postgres
</pre>

## DBMS Initialization

When the app first starts, it creates the tables needed to hold the
data.

For the first login, you don't need to enter a user ID or password -
the app logs you in as the machine generated administrator - ID admin,
password admin.  From there, you can enter employee, manager, and
administrator users.
