package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.org.myinfo.model.State;
@Transactional
public interface StateRepository extends CrudRepository<State, Integer>{
	
	
}