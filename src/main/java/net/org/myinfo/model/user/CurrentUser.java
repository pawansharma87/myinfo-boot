package net.org.myinfo.model.user;

import org.springframework.security.core.authority.AuthorityUtils;

import net.org.myinfo.model.Role;

public class CurrentUser extends org.springframework.security.core.userdetails.User {
	private User user;

	public CurrentUser(User user) {
		super(user.getUsername(), user.getPassword(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public Long getId() {
		return user.getId();
	}

	public User getUser() {
		return user;
	}

	public Role getRole() {
		return user.getRole();
	}
}