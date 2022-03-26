package me.develop_han.TDD_start.mock.stub;

public class UserRegister {
	private StubWeakPasswordChecker passwordChecker;

	public UserRegister(StubWeakPasswordChecker passwordChecker) {
		this.passwordChecker = passwordChecker;
	}

	public void register(String id, String pw, String email) {
		if(passwordChecker.checkPasswordWeak(pw)) {
			throw new WeakPasswordException();
		}
	}
}
