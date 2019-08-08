package com.ojas.gst.dao;

import com.ojas.gst.entity.VerificationToken;

public interface VerificationTokenDao extends Dao<VerificationToken,Long>{
	
	VerificationToken findByToken(String token);
	
	VerificationToken findByUser(String token);

}
