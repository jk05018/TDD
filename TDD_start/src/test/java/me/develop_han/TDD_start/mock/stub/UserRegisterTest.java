package me.develop_han.TDD_start.mock.stub;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRegisterTest {
	private UserRegister userRegister;
	private StubWeakPasswordChecker stubWeakPasswordChecker = new StubWeakPasswordChecker();

	@BeforeEach
	void setUp(){
		userRegister = new UserRegister(stubWeakPasswordChecker);
	}

	@DisplayName("약한 암호면 가입 실패")
	@Test
	public void if_weak_password_then_join_fail() throws Exception{
		stubWeakPasswordChecker.setWeak(true); // 암호가 약하다고 응답하도록 설정

		Assertions.assertThrows(WeakPasswordException.class, () -> {
			userRegister.register("id","pw","email");
		});
	}
}
