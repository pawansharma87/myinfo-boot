package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.org.myinfo.model.District;
@Transactional
public interface DisttRepository extends CrudRepository<District, Integer>{
	
	
}