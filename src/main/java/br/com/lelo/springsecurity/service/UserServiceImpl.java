package br.com.lelo.springsecurity.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.lelo.springsecurity.domain.User;
import br.com.lelo.springsecurity.domain.UserCreateForm;
import br.com.lelo.springsecurity.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<User> getUserById(long id) {
		return Optional.ofNullable(userRepository.findOne(id));
	}

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public Collection<User> getAllUsers() {
		return userRepository.findAll(new Sort("email"));
	}

	@Override
	public User create(UserCreateForm form) {
		return userRepository.save(new User(form.getEmail(), form.getPassword(), form.getRole()));
	}

}
