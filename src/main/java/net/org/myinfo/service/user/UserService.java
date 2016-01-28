package net.org.myinfo.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import net.org.myinfo.model.user.CurrentUser;
import net.org.myinfo.model.user.User;

public interface UserService {
	User getUserByUsername(String username);

	User getLoggedInUser();

	Optional<User> getUserById(long id);

	boolean canAccessUser(CurrentUser currentUser, Long userId);

	Collection<User> getAllUsers();

	User create(User user);

	void autoLogin(String userName);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
