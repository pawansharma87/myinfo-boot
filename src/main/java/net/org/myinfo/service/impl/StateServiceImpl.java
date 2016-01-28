package net.org.myinfo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.State;
import net.org.myinfo.repository.StateRepository;
import net.org.myinfo.service.StateService;

@Service
public class StateServiceImpl implements StateService {
    @Autowired
	private StateRepository stateRepository;

	@Override
	public Iterable<State> listAllStates() {
	return stateRepository.findAll();
	}

	@Override
	public State getStateById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public State saveState(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteState(Integer id) {
		// TODO Auto-generated method stub
		
	}
 
    
}