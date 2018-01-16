package br.com.lelo.springsecurity.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lelo.springsecurity.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findOneByEmail(String email);
}
