package br.com.lelo.springsecurity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Long id;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	public User() {
	}

	public User(String email, String password, RoleEnum role) {
		this.email = email;
		this.role = role;
		this.passwordHash = crytpPass(password);
	}

	public static void main(String[] args) {
		System.out.println(User.crytpPass("teste"));
	}

	public static String crytpPass(String password) {
		return new BCryptPasswordEncoder().encode(password);
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public RoleEnum getRole() {
		return role;
	}

	public void setRole(RoleEnum role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", email='" + email.replaceFirst("@.*", "@***") + ", passwordHash='" + passwordHash.substring(0, 10) + ", role="
				+ role + '}';
	}
}
