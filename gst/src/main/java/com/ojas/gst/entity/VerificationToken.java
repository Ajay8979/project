package com.ojas.gst.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@javax.persistence.Entity
public class VerificationToken implements Entity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int EXPIRATION = 60 * 24;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String token;

	@OneToOne(targetEntity = User.class)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;

	private Date expiry;

	public VerificationToken() {
		super();
	}

	public VerificationToken(final String token) {
		super();
		this.token = token;
		this.expiry = calculateExpiryDate(EXPIRATION);

	}

	public VerificationToken(final String token, final User user) {
		super();
		this.token = token;
		this.user = user;
		this.expiry = calculateExpiryDate(EXPIRATION);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static int getExpiration() {
		return EXPIRATION;
	}

	public Date getExpiry() {
		return expiry;
	}

	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	private Date calculateExpiryDate(final int expiryTimeInMinutes) {
		final Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(new Date().getTime());
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		return new Date(cal.getTime().getTime());

	}

	@Override
	public String toString() {
		return "VerificationToken [id=" + id + ", token=" + token + ", expiry=" + expiry + "]";
	}

}
