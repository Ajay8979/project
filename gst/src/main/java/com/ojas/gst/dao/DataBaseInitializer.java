package com.ojas.gst.dao;



import org.springframework.security.crypto.password.PasswordEncoder;





/**
 * Initialize the database with some test entries.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DataBaseInitializer {

	private UserDao userDao;


	protected DataBaseInitializer() {
		// Default constructor for reflection instantiation
	}

	public DataBaseInitializer(UserDao userDao, PasswordEncoder passwordEncoder) {
		this.userDao = userDao;
	}

	public void initDataBase() {
		
		/*
		 * User adminUser = new User(); //adminUser.addRole(Role.ADMIN);
		 * adminUser.setStatus("Active"); List<User> list = new ArrayList<User>();
		 * list=userDao.findAll(); if(null==list ||list.isEmpty()) {
		 * this.userDao.save(adminUser); }
		 */

		//long timestamp = System.currentTimeMillis() - (1000 * 60 * 60 * 24);
		
	}
}
