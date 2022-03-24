package me.develop_han.TDD_start.join_tdd.stub.repository;

import me.develop_han.TDD_start.join_tdd.stub.domain.User;

public interface UserRepository {
	void save(User user);
	User findById(String id);
}
