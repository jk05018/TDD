package me.develop_han.TDD_start.join_tdd.stub.domain;

public class User {
	private String id;
	private String password;
	private String email;

	public User(String id, String password, String email) {
		this.id = id;
		this.password = password;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}
}
