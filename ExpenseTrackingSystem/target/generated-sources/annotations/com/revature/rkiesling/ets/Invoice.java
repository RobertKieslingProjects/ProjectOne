package com.revature.rkiesling.ets;

public class Invoice {

    private String userid;
    private Float amount;
    private String vendor;
    private String invoiceno;
    private String description;

    Invoice () {
	super ();
    }

    Invoice (String userid, Float amount, String vendor, String invoiceno, String description) {
	this.userid = userid;
	this.amount = amount;
	this.vendor = vendor;
	this.invoiceno = invoiceno;
	this.description = description;
    }
    String userid () {
	return this.userid;
    }
    void userid (String s) {
	this.userid = s;
    }
    Float amount () {
	return this.amount;
    }
    void amount (Float f) {
	this.amount = f;
    }
    String vendor () {
	return this.vendor;
    }
    void vendor (String s) {
	this.vendor = s;
    }
    String invoiceno () {
	return this.invoiceno;
    }
    void invoiceno (String s) {
	this.invoiceno = s;
    }
    String description () {
	return this.description;
    }
    void description (String s) {
	this.description = s;
    }

}
