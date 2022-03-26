package me.develop_han.TDD_start.mock.stub;

public interface UserRepository {
	void save(User user);
	User findById(String id);
}
