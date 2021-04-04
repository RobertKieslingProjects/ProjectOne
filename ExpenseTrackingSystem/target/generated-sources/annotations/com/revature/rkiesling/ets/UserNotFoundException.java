package com.revature.rkiesling.ets;

public class UserNotFoundException extends Throwable {
	UserNotFoundException () {
		super ();
	}
	UserNotFoundException (String message) {
		super (message);
	}
}
