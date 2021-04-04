# Expense Tracking Project - Installation and Startup


## Importing the Project from Github into Spring Tools Suite

1. Using a web browser, navigate to the project's repository on
   Github:

<pre>
https://github.com/RobertKieslingProjects/ProjectOne
</pre>

2. Click on the green, "Code," button, and note the HTTPS URL
   displayed in the drop down menu.  You can copy this URL by clicking
   on the clipboard icon on the right of the URL.
   
3. Create a new directory that will hold a local copy of project.

4. In the new directory, type the following command, using the
   link that you copied in step 2.

<pre>
git clone <https-link-from-step-2>
</pre>

5. Start Spring Tools, and, to import the project most directly, select
   as a workspace the directory that you created in step 3, plus the 
   directory name of the repository that you cloned in step 4.
   
   For example, if in step 3 you created the directory, 
   
<pre>
/home/jim/builds/ets-ws
</pre>

then your workspace directory would be,

<pre>
/home/jim/builds/ets-ws/ProjectOne
</pre>

6. Once Spring Tools has started, select File > Open Projects From File
   System from the menu.  Select ExpenseTrackingSystem in your workspace
   directory.  Using these examples, that path would be:
   
<pre>
/home/jim/builds/ets-ws/ProjectOnce/ExpenseTrackingSystem
</pre>

7. Import the project.  If Spring Tools is configured to build
   projects automatically (which is the default), the import and
   build might generate errors.  In that case, select Project > 
   Clean... from the menu.  Select this project and click clean.
   
8. If all of the project's dependencies are imported correctly, then
   you should be able to configure the HTTP server (per the Spring
   Tools documentation) and the DBMS connection and initialization (as
   described below).  When first getting started, you'll probably need
   to configure the DBMS connection in the server's environment.
   
   If the server is configured correctly, you should be able to view
   the app's Login page.  If the app doesn't display any further
   pages, then review the DBMS connection in the server environment.
   
   Please note that the project is only tested with Java 1.8.  You may
   be able to set your JRE version in the project's pom.xml file, but
   Your Mileage May Vary.


## Connecting to the DBMS

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

When the app first starts, it creates the DBMS and the tables needed
for the data.

For the first login, you don't need to enter a user ID or password -
the app logs you in as the machine-generated administrator - the ID
is, "admin," and the password, "admin."  From there, you can enter
employee, manager, and admin users.
