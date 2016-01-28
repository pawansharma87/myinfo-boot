package net.org.myinfo.service.impl;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import net.org.myinfo.model.Role;
import net.org.myinfo.model.user.CurrentUser;
import net.org.myinfo.model.user.User;
import net.org.myinfo.repository.UserRepository;
import net.org.myinfo.service.user.CurrentUserDetailsService;
import net.org.myinfo.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	public final String CURRENT_USER_KEY = "CURRENT_USER";

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	HttpSession httpSession;

	/*
	 * @Override public Optional<User> getUserByUsername(String username) {
	 * return userRepository.findOneByUsername(username); }
	 */

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Optional<User> getUserById(long id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	/*
	 * @Override public User getUserByEmail(String username) { return
	 * userRepository.findByUsername(username); }
	 */

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	public User create(User user) {
		/*
		 * User user = new User(); user.setUsername(form.getUsername());
		 * user.setPassword(new
		 * BCryptPasswordEncoder().encode(form.getPassword()));
		 * user.setRole(form.getRole());
		 */
		String password = new BCryptPasswordEncoder().encode(user.getPassword());
		user.setPassword(password);
		user.setRole(Role.ROLE_USER);
		return userRepository.save(user);
	}

	public void autoLogin(String username) {
		UserDetails userDetails = this.loadUserByUsername(username);
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());

		SecurityContextHolder.getContext().setAuthentication(auth);
		if (auth.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		httpSession.setAttribute(CURRENT_USER_KEY, user);
		List<GrantedAuthority> auth = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getRole().toString());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), auth);
	}

	@Override
	public User getLoggedInUser() {
		Boolean forceFresh = false;
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = (User) httpSession.getAttribute(CURRENT_USER_KEY);
		if (forceFresh || httpSession.getAttribute(CURRENT_USER_KEY) == null) {
			user = userRepository.findByUsername(userName);
			httpSession.setAttribute(CURRENT_USER_KEY, user);
		}
		return user;
	}

	@Override
	public boolean canAccessUser(CurrentUser currentUser, Long userId) {
		LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
		return currentUser != null && (currentUser.getRole() == Role.ROLE_ADMIN || currentUser.getId().equals(userId));
	}

}
