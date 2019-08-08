package com.ojas.gst.dao;

import java.util.List;


import com.ojas.gst.entity.State;
import com.ojas.gst.entity.TaxPayersType;

public interface StateDao extends Dao<State, Long> {

	List<State> getAllStates();

	int deleteById(State state);
	
	int updateStateById(State state);
	
}
