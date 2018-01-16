package br.com.lelo.springsecurity.service;

import org.springframework.stereotype.Service;

import br.com.lelo.springsecurity.domain.CurrentUser;
import br.com.lelo.springsecurity.domain.RoleEnum;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

	@Override
	public boolean canAccessUser(CurrentUser currentUser, Long userId) {
		return currentUser != null && (currentUser.getRole() == RoleEnum.ADMIN || currentUser.getId().equals(userId));
	}

}
