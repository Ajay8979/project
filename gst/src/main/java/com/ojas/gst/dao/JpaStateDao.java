package com.ojas.gst.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Query;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import com.ojas.gst.entity.State;
public class JpaStateDao extends JpaDao<State, Long> implements StateDao{
	
	public JpaStateDao() {
		super(State.class);
	}
	
	@Column(name = "state_id")
	private Long id;

	@Column(name = "state_name",unique=true)
	private String stateName;

	@Column(name = "state_updatedBy")
	private Long lastUpdatedBy;

	@Column(name = "state_status")
	private String status;

	@Column(name = "state_updatedDate")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(name = "state_email")
	private String email;

	@Override
	public List<State> getAllStates() {
		Query query = getEntityManager().createNativeQuery(
				" select state_id,state_name,state_updatedBy,state_updatedDate,state_status,state_email from gst.state  order by state_id desc");
		@SuppressWarnings("unchecked")
		List<Object[]> stateObjectList = query.getResultList();
		List<State> stateList = new ArrayList<State>();

		for (Object[] object : stateObjectList) {
			State state = new State();
			state.setId(Long.parseLong(object[0] + ""));
			state.setStateName((object[1] + ""));
			if(object[2] != null) {
				state.setLastUpdatedBy(Long.parseLong(object[2] + ""));
			}
			
			state.setUpdatedDate((Date) object[3]);
			state.setStatus(object[4] + "");
			state.setEmail(object[5] + "");
			stateList.add(state);
		}
		return stateList;
	}

	@Transactional
	@Override
	public int deleteById(State state) {
		Query query = getEntityManager().createNativeQuery("update state set state_status='"
				+ state.getStatus() + "' where state_id=" + state.getId());
		return query.executeUpdate();
	}

	@Override
	public int updateStateById(State state) {
		Query query = getEntityManager().createNativeQuery("update state set state_status='"
				+ state.getStatus() + "',state_name ='"+state.getStateName()+ "',state_updatedBy ='"+state.getLastUpdatedBy()+"'taxpayerstype_updatedDate'"+state.getUpdatedDate()+"'where state_id=" + state.getId());
		return query.executeUpdate();
	}
	

}
