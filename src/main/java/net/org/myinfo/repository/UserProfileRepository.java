package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import net.org.myinfo.model.UserProfile;
import net.org.myinfo.model.user.User;
@Transactional
public interface UserProfileRepository extends CrudRepository<UserProfile, Long>{
	
	/**
	   * Return the user having the passed email or null if no user is found.
	   * 
	   * @param email the user email.
	   */	  
	UserProfile findByName(String name);
	UserProfile findByUserId(Long userId);
	public UserProfile findByEmail(String email);
}