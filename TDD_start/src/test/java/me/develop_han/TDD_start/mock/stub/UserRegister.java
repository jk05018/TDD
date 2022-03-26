package me.develop_han.TDD_start.mock.stub;

public class UserRegister {
	private StubWeakPasswordChecker passwordChecker;
	private UserRepository repository;
	private EmailNotifier emailNotifier;

	public UserRegister(StubWeakPasswordChecker passwordChecker,
		UserRepository repository, EmailNotifier emailNotifier) {
		this.passwordChecker = passwordChecker;
		this.repository = repository;
		this.emailNotifier = emailNotifier;
	}

	public void register(String id, String pw, String email) {
		if(passwordChecker.checkPasswordWeak(pw)) {
			throw new WeakPasswordException();
		}
		User user = repository.findById(id);
		if(user != null){
			throw new DupidExeption();
		}

		repository.save(new User(id,pw,email));
		emailNotifier.sendRegisterEmail(email);
	}
}
