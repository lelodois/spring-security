package br.com.lelo.springsecurity.domain;

import org.springframework.security.core.authority.AuthorityUtils;

public class CurrentUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -491088884754842917L;
	private User user;

	public CurrentUser(User user) {
		super(user.getEmail(), user.getPasswordHash(), AuthorityUtils.createAuthorityList(user.getRole().toString()));
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public Long getId() {
		return user.getId();
	}

	public RoleEnum getRole() {
		return user.getRole();
	}

	@Override
	public String toString() {
		return "CurrentUser{" + "user=" + user + "} " + super.toString();
	}
}
