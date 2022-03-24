package me.develop_han.TDD_start.join_tdd.stub.repository;

import java.util.HashMap;
import java.util.Map;

import me.develop_han.TDD_start.join_tdd.stub.domain.User;

public class MemoryUserRepository implements UserRepository {
	private Map<String, User> users = new HashMap<>();

	@Override
	public void save(User user) {
		users.put(user.getId(), user);
	}

	@Override
	public User findById(String id) {
		if (users.keySet().contains(id)) {
			return users.get(id);
		}
		return null;
	}
}
