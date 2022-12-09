package com.example.hr_request_tracker.hr_request_tracker.user.messages;

import com.example.hr_request_tracker.hr_request_tracker.common.Messages;

public interface UserMessages extends Messages {
	String USER_SUCCESSFULLY_SAVED = "User was successfully saved!";
	String USER_SUCCESFULLY_UPDATED = "User was successfully updated!";
	String USER_SUCCESSFULLY_DELETED = "User was successfully deleted!";
	
	String USER_SUCCESSFULLY_LOGGED = "User successfully logged in.";
	String USER_UNSUCCESSFUL_LOGGED = "User not found.";
	
	String PASSWORD_SUCCESSFULLY_UPDATED = "Password successfully updated!";
}
