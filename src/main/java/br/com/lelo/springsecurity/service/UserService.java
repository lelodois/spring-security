package br.com.lelo.springsecurity.service;

import java.util.Collection;
import java.util.Optional;

import br.com.lelo.springsecurity.domain.User;
import br.com.lelo.springsecurity.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
