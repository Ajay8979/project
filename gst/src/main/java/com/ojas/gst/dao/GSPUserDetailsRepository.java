//package com.ojas.gst.dao;
//
//import java.util.Optional;
//
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.ojas.gst.model.registration.GSPUser;
//import com.ojas.gst.model.registration.GSTINDetails;
//
//@Repository
//@Transactional
//public interface GSPUserDetailsRepository extends JpaRepository<GSPUser, Integer> {
//	
//	//get GSPUser by userId and EmailId
//    Optional<GSPUser> findByUserIdOrEmailId(String userId, String emailId);
//    //get GSPUser by EmailId
//    Optional<GSPUser> findByEmail(String email);
//    
//    Optional<GSPUser> findByUserId(Long userId);
//    
//}
