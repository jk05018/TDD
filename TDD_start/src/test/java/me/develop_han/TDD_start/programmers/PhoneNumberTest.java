package me.develop_han.TDD_start.programmers;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneNumberTest {

	// 한글로 써도 된다.
	@Test
	void phoneNumber_객체_생성(){
		// given
		PhoneNumber phoneNumber = new PhoneNumber("01012345678");
		assertThat(phoneNumber).isNotNull();

	}

	/**
	 * 010-1234-567의 형태로 리턴하고 싶다
	 */
	@Test
	void dash가_붙은_문자열을_반호나한다() {
		PhoneNumber phoneNumber = new PhoneNumber("01012345678");
		String actual = phoneNumber.toStringWithDash();

		assertThat(actual).isEqualTo("010-1234-5678");

		PhoneNumber phoneNumber2 = new PhoneNumber("01012341234");
		String actual2 = phoneNumber2.toStringWithDash();

		assertThat(actual2).isEqualTo("010-1234-1234");
	}

	@Test
	void dash가_붙은_문자열을_반호나한다_가운데가_3자리인_경우() {
		PhoneNumber phoneNumber = new PhoneNumber("0101235678");
		String actual = phoneNumber.toStringWithDash();

		assertThat(actual).isEqualTo("010-123-5678");

	}

	@Test
	void Dash가_없는_문자열을_반환한다() {
		PhoneNumber phoneNumber2 = new PhoneNumber("01012341234");
		String actual2 = phoneNumber2.toStringWithoutDash();

		assertThat(actual2).isEqualTo("01012341234");
	}
}
