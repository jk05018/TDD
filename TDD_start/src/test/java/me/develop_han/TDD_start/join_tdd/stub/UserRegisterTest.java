package me.develop_han.TDD_start.join_tdd.stub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import me.develop_han.TDD_start.join_tdd.stub.domain.SpyEmailNotifier;
import me.develop_han.TDD_start.join_tdd.stub.domain.StubWeakPasswordChecker;
import me.develop_han.TDD_start.join_tdd.stub.domain.User;
import me.develop_han.TDD_start.join_tdd.stub.domain.UserRegister;
import me.develop_han.TDD_start.join_tdd.stub.exception.DupIdException;
import me.develop_han.TDD_start.join_tdd.stub.exception.WeakPasswordException;
import me.develop_han.TDD_start.join_tdd.stub.repository.MemoryUserRepository;

public class UserRegisterTest {
	private UserRegister userRegister;
	private StubWeakPasswordChecker stubPasswordChecker = new StubWeakPasswordChecker();
	private MemoryUserRepository fakeRepository = new MemoryUserRepository();
	private SpyEmailNotifier spyEmailNotifier = new SpyEmailNotifier();

	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(stubPasswordChecker, fakeRepository, spyEmailNotifier);
	}

	@DisplayName("1. 약한 암호면 가입 실패")
	@Test
	public void weak_password_then_fail() throws Exception {
		stubPasswordChecker.setWeak(true); //암호가 약하다고 응답하도록 설정

		assertThrows(WeakPasswordException.class, () ->
			userRegister.register("id", "pw", "email"));
	}

	@DisplayName("2. 이미 같은 ID가 존재하면 가입 실패")
	@Test
	public void if_duplicate_then_fail() throws Exception {
		//  when 이미 같은 ID 존재하는 상황 만들기
		fakeRepository.save(new User("id", "pw1", "email.com"));

		assertThrows(DupIdException.class, () ->
			userRegister.register("id", "pw2", "email")
		);
	}

	@DisplayName("3. 가입하면 이메일을 전송함")
	@Test
	public void register_then_send_email() throws Exception {
		userRegister.register("id", "pw", "email@email.com");

		assertTrue(spyEmailNotifier.isCalled());
		assertEquals("email@email.com", spyEmailNotifier.getEmail());
	}
}
