package com.ojas.gst.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ojas.gst.entity.AccessToken;
import com.ojas.gst.entity.User;
import com.ojas.gst.response.Response;




public interface UserDao extends Dao<User, Long> {
	
	Response loadUserByUsername(String username) throws UsernameNotFoundException;
	User findByName(String name);
	AccessToken findAccessTokenByUserId(Long id,String token);
	Response findAllAdmins();
	Response findAllUserByPages(Integer pageNumber, Integer pageSize);
	List<User> findAllUsers();
	User findUserByPassword(String password);
	int updatePassword(String currentPassword, String newPassword,User user);
	int createNewPassword(String newPassword , String email,User user);
	
	
}
