package me.develop_han.TDD_start;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {

	@DisplayName("1. 모든 조건을 충족한다면 암호 강도는 강함이어야 함")
	@Test
	public void meetsAllCriteria_Then_Strong() throws Exception {

		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@AB");
		assertEquals(result, PasswordStrength.STRONG);

		PasswordStrength result2 = meter.meter("abc1!Add");
		assertEquals(result2, PasswordStrength.STRONG);

	}

	@DisplayName("2. 길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
	@Test
	public void meetOtherCriteria_except_for_Length_Then_Normal() throws Exception {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab12!@A");
		assertEquals(result, PasswordStrength.NORMAL);

		PasswordStrength result2 = meter.meter("AB12!c");
		assertEquals(result2, PasswordStrength.NORMAL);
	}

	@DisplayName("3. 숫자르 포함하지 않고 나머지 조건을 충족한 경우")
	@Test
	public void meetsOtherCreteria_except_for_number_Then_Normal() throws Exception {
		PasswordStrengthMeter meter = new PasswordStrengthMeter();
		PasswordStrength result = meter.meter("ab!@ABqwer");
		assertEquals(result, PasswordStrength.NORMAL);
	}
}
