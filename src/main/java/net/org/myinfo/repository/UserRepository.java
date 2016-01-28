package net.org.myinfo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.org.myinfo.model.user.User;
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	   * Return the user having the passed email or null if no user is found.
	   * 
	   * @param email the user email.
	   */	  
	/*Optional<User> findOneByUsername(String username);*/
	
	User findByUsername(String username);
}