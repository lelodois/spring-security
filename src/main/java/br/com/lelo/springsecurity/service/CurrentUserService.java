package br.com.lelo.springsecurity.service;

import br.com.lelo.springsecurity.domain.CurrentUser;

public interface CurrentUserService {

    boolean canAccessUser(CurrentUser currentUser, Long userId);

}
