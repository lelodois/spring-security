package br.com.lelo.springsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.lelo.springsecurity.domain.CurrentUser;
import br.com.lelo.springsecurity.domain.User;

@Service
public class CurrentUserDetailsServiceWrapper implements UserDetailsService {

	private final UserService userService;

	@Autowired
	public CurrentUserDetailsServiceWrapper(UserService userService) {
		this.userService = userService;
	}

	@Override
	public CurrentUser loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUserByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException(String.format("User with email=%s was not found", email)));
		return new CurrentUser(user);
	}

}
