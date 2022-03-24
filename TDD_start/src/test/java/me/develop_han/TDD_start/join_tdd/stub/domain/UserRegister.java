package me.develop_han.TDD_start.join_tdd.stub.domain;

import me.develop_han.TDD_start.join_tdd.stub.exception.DupIdException;
import me.develop_han.TDD_start.join_tdd.stub.exception.WeakPasswordException;
import me.develop_han.TDD_start.join_tdd.stub.repository.UserRepository;

public class UserRegister {
	private StubWeakPasswordChecker passwordChecker;
	private UserRepository userRepository;
	private EmailNotifier emailNotifier;

	public UserRegister(StubWeakPasswordChecker passwordChecker,
		UserRepository userRepository, EmailNotifier emailNotifier) {
		this.passwordChecker = passwordChecker;
		this.userRepository = userRepository;
		this.emailNotifier = emailNotifier;
	}

	public void register(String id, String pw, String email) {
		if (passwordChecker.checkPasswordWeak(pw)) {
			throw new WeakPasswordException();
		}
		User user = userRepository.findById(id);
		if (user != null) {
			throw new DupIdException();
		}
		userRepository.save(new User(id, pw, email));
		emailNotifier.sendRegisterEmail(email);
	}

}
