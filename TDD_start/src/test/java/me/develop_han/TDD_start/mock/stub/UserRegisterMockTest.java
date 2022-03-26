package me.develop_han.TDD_start.mock.stub;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import me.develop_han.TDD_start.mock.stub.domain.EmailNotifier;
import me.develop_han.TDD_start.mock.stub.domain.MemoryUserRepository;
import me.develop_han.TDD_start.mock.stub.domain.UserRegister;
import me.develop_han.TDD_start.mock.stub.domain.UserRepository;
import me.develop_han.TDD_start.mock.stub.domain.WeakPasswordChecker;
import me.develop_han.TDD_start.mock.stub.exception.WeakPasswordException;

public class UserRegisterMockTest {
	private UserRegister userRegister;
	private WeakPasswordChecker mockPasswordChecker = mock(WeakPasswordChecker.class);
	// Mock에서는 fake를 지원하지는 않는다 한번 이유에 대해서 고찰해보기
	private MemoryUserRepository memoryUserRepository = new MemoryUserRepository();
	private EmailNotifier mockEmailNotifier = mock(EmailNotifier.class);

	@BeforeEach
	void setUp() {
		userRegister = new UserRegister(mockPasswordChecker, memoryUserRepository, mockEmailNotifier);
	}

	@DisplayName("약한 암호면 가입 실패")
	@Test
	public void if_weakPassword_then_fail() throws Exception {
		BDDMockito.given(mockPasswordChecker.checkPasswordWeak("pw")).willReturn(true);

		assertThrows(WeakPasswordException.class, () -> {
			userRegister.register("id", "pw", "email@email.com");
		});
	}

	@DisplayName("2. 회원 가입 시 암호 검사 수행")
	@Test
	public void if_register_checkPassword_done() throws Exception {
		userRegister.register("id", "pw", "email@email.com");

		BDDMockito.then(mockPasswordChecker).should()
			.checkPasswordWeak(BDDMockito.anyString());
	}

	@DisplayName("3. 가입하면 메일을 전송함")
	@Test
	public void if_register_send_email() throws Exception {
		userRegister.register("id", "pw", "email@email.com");

		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		BDDMockito.then(mockEmailNotifier)
			.should()
			.sendRegisterEmail(captor.capture());

		String realEmail = captor.getValue();
		assertEquals("email@email.com", realEmail);
	}
}
