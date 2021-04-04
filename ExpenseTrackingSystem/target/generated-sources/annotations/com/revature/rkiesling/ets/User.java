package com.revature.rkiesling.ets;

public class User {
	private String firstName = "";
	private String lastName = "";
	private String userid = "";
	private String password = "";
	private String SSN = "";
	private int role;
	
	User () {
		super ();
	}
    User (String firstName, String lastName, String userid,
	  String SSN, int role) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userid = userid;
	this.SSN = SSN;
	this.role = role;
    }
    User (String firstName, String lastName, String userid, String password,
	  String SSN, int role) {
	this.firstName = firstName;
	this.lastName = lastName;
	this.userid = userid;
	this.password = password;
	this.SSN = SSN;
	this.role = role;
    }
    String firstName () { return this.firstName; }
    void firstName (String name) { this.firstName = name; }
    String lastName () { return this.lastName; }
    void lastName (String name) { this.lastName = name; }
    String userid () { return this.userid; }
    void userid (String id) { this.userid = id; }
    String password () { return this.password; }
    void password (String p) { this.password = p; }
    String SSN () { return this.SSN; }
    void SSN (String ssn) { this.SSN = ssn; }
    Integer role () { return this.role; }
    void role (Integer r) { this.role = r; }
}
