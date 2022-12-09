package com.example.hr_request_tracker.hr_request_tracker.authentication.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.hr_request_tracker.hr_request_tracker.user.model.User;

@Entity
@Table(name="token")
public class Token {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="token_id")
	private int tokenID;
	
	@Column(name="auth_token")
	private String authToken;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="expires_at")
	private LocalDate expiresAt;
	
	public int getTokenID() {
		return tokenID;
	}
	
	public String getAuthToken() {
		return authToken;
	}
	
	public User getUser() {
		return user;
	}
	
	public LocalDate getExpiresAt() {
		return expiresAt;
	}
	
	public void setTokenID(int tokenID) {
		this.tokenID = tokenID;
	}
	
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setExpiresAt(String expiresAt) {
		this.expiresAt = LocalDate.parse(expiresAt);
	}
}

