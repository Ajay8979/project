package com.ojas.gst.dao;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.ojas.gst.entity.AccessToken;
import com.ojas.gst.entity.User;
import com.ojas.gst.response.Response;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class JpaUserDao extends JpaDao<User, Long> implements UserDao {
	public JpaUserDao() {
		super(User.class);
	}

	@Transactional(readOnly = true)
	public Response loadUserByUsername(String username) // throws
														// UsernameNotFoundException
	{
		Response response = new Response();
		User user = this.findByName(username);
		try {
			if (null == user) {
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
			}
			response.setStatusCode(HttpStatus.OK.value());
			response.setResponseData(user);
		} catch (UsernameNotFoundException une) {
			System.out.println(une.toString());
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
		}

		return response;
	}

	@Transactional(readOnly = true)
	public User findByName(String name) {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(this.entityClass);

		Root<User> root = criteriaQuery.from(this.entityClass);
		Path<String> namePath = root.get("eamilAddress");
		criteriaQuery.where(builder.equal(namePath, name));

		TypedQuery<User> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		List<User> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}

	public AccessToken findAccessTokenByUserId(Long id, String token) {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<AccessToken> criteriaQuery = builder.createQuery(AccessToken.class);
		Root<AccessToken> root = criteriaQuery.from(AccessToken.class);
		Path<String> namePath = root.get("user");
		Path<String> tokenPath = root.get("token");
		criteriaQuery.where(builder.equal(namePath, id));
		criteriaQuery.where(builder.equal(tokenPath, token));

		TypedQuery<AccessToken> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		AccessToken accessToken = typedQuery.getSingleResult();
		return accessToken;

	}

	@SuppressWarnings("unchecked")
	public Response findAllAdmins() {
		Response response = new Response();
		try {
			Query query = this.getEntityManager().createNativeQuery(
					"SELECT u.id,u.username,u.password,u.aadharnumber,u.dob,u.mobilenumber,u.status,u.candidateName FROM users u LEFT JOIN user_roles r ON u.id = r.user_id where r.roles = 2");
			List<Object[]> admins = query.getResultList();
			ArrayList<User> adminsList = new ArrayList<User>();
			if (admins.isEmpty()) {
				response.setResponseMessage("No Admins Found");
				response.setStatusCode(HttpStatus.NO_CONTENT.value());
			} else {
				for (Object[] a : admins) {
					User admin = new User();
					admin.setId(Long.parseLong(a[0] + ""));
					admin.setStatus((String) a[6]);
					/*
					 * Set<Role> roles = new HashSet<Role>(); roles.add(Role.ADMIN);
					 */
					adminsList.add(admin);
				}

				response.setResponseMessage("Admins List Retrieved");
				response.setStatusCode(HttpStatus.OK.value());
				response.setResponseDataList(adminsList);
			}

		} catch (Exception e) {
			response.setResponseMessage("Error Occured while Retrieving Admins List");
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}
		return response;
	}

	@SuppressWarnings("unchecked")	
	public Response findAllUserByPages(Integer pageNumber, Integer pageSize) {
		Response response = new Response();
		try {
			Query query = this.getEntityManager().createNativeQuery(
					"SELECT u.id, u.aadharnumber, u.dob, u.mobilenumber, u.username, u.password, u.status,u.candidateName FROM users u LEFT JOIN user_roles r ON u.id = r.user_id WHERE r.roles = 0 ORDER BY id DESC OFFSET "
							+ pageNumber * pageSize + " FETCH NEXT " + pageSize + " ROWS ONLY ");
			List<Object[]> users = query.getResultList();
			ArrayList<User> usersList = new ArrayList<User>();
			if (users.isEmpty()) {
				response.setResponseMessage("No Users Found");
				response.setStatusCode(HttpStatus.NO_CONTENT.value());
			} else {
				for (Object[] a : users) {
					User user = new User();	
					user.setStatus((String) a[6]);
					/*
					 * Set<Role> roles = new HashSet<Role>(); roles.add(Role.USER);
					 */
					usersList.add(user);
				}

				response.setResponseMessage("Users List Retrieved");
				response.setStatusCode(HttpStatus.OK.value());
				response.setResponseDataList(usersList);
			}

		} catch (Exception e) {
			response.setResponseMessage("Error Occured while Retrieving Users List");
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			e.printStackTrace();
		}
		return response;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		ArrayList<User> usersList = new ArrayList<>();
		try {
			Query query = this.getEntityManager().createNativeQuery(
					"SELECT u.id, u.address, u.city, u.clientName, u.eamilAddress, u.mobileNumber, u.panNumber,u.password,u.pinCode,u.relationShip,u.servicesRequired,u.state,u.status,u.type,u.username,u.role FROM users u");
			List<Object[]> users = query.getResultList();
			
			if (users != null) {
				for (Object[] a : users) {
					User user = new User();
					user.setId(Long.parseLong(a[0] + ""));
					user.setAddress((String) a[1]);
					user.setCity((String) a[2]);
					user.setClientName((String) a[3]);
					user.setEamilAddress((String) a[4]);
					if(a[5] != null ) {
						user.setMobileNumber(Long.parseLong(a[5]+""));
					}
					
					user.setPanNumber((String) a[6]);
					user.setPassword((String) a[7]);
					if(a[8] != null) {
						user.setPinCode(Long.parseLong(a[8]+""));
					}					
					user.setRelationShip((String) a[9]);
					user.setServicesRequired((String) a[10]);
					user.setState((String) a[11]);
					user.setStatus((String) a[12]);
					user.setType((String) a[13]);
					user.setUsername((String) a[14]);
					user.setRole((String) a[15]);
					usersList.add(user);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usersList;
	}

	@Transactional(readOnly = true)
	@Override
	public User findUserByPassword(String password) {
		final CriteriaBuilder builder = this.getEntityManager().getCriteriaBuilder();
		final CriteriaQuery<User> criteriaQuery = builder.createQuery(this.entityClass);

		Root<User> root = criteriaQuery.from(this.entityClass);
		Path<String> namePath = root.get("password");
		criteriaQuery.where(builder.equal(namePath, password));

		TypedQuery<User> typedQuery = this.getEntityManager().createQuery(criteriaQuery);
		List<User> users = typedQuery.getResultList();

		if (users.isEmpty()) {
			return null;
		}

		return users.iterator().next();
	}
    @Transactional
	@Override
	public int updatePassword(String currentPassword, String newPassword,User user) {
			Query query = getEntityManager().createNativeQuery("update gst.users set password='"
					+ newPassword + "' where id=" + user.getId());
			return query.executeUpdate();
	}

	@Override
	public int createNewPassword(String newPassword, String email,User user) {
		Query query = getEntityManager().createNativeQuery("update gst.users set password='"
				+ newPassword + "' where id=" + user.getId());
		return query.executeUpdate();
	}
		
}
