package me.develop_han.TDD_start;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordStrengthMeterTest {
	PasswordStrengthMeter meter = new PasswordStrengthMeter();

	@DisplayName("1. 모든 조건을 충족한다면 암호 강도는 강함이어야 함")
	@Test
	public void meetsAllCriteria_Then_Strong() throws Exception {
		assertStrength("ab12!@AB", PasswordStrength.STRONG);
		assertStrength("abc1!Add", PasswordStrength.STRONG);

	}

	@DisplayName("2. 길이만 8글자 미만이고 나머지 조건은 충족하는 경우")
	@Test
	public void meetOtherCriteria_except_for_Length_Then_Normal() throws Exception {
		assertStrength("ab12!@A", PasswordStrength.NORMAL);
		assertStrength("AB12!c", PasswordStrength.NORMAL);
	}

	@DisplayName("3. 숫자르 포함하지 않고 나머지 조건을 충족한 경우")
	@Test
	public void meetsOtherCreteria_except_for_number_Then_Normal() throws Exception {
		assertStrength("ab!@ABqwer", PasswordStrength.NORMAL);
	}

	@DisplayName("4. 값이 존재하지 않을 경우 ")
	@Test
	public void nullInput_Then_Invalid() throws Exception {
		assertStrength(null, PasswordStrength.INVALID);
	}

	@DisplayName("5. 대문자를 포함하지 않고 나머지 조건을 충족하는 경우")
	@Test
	public void meetsOtherCriteria_except_for_Uppercase_then_Normal() throws Exception{
		assertStrength("ab12!@df",PasswordStrength.NORMAL);
	}

	@DisplayName("6. 길이가 8글자 이상인 조건만 충족하는 경우")
	@Test
	public void meetsOnlyLengthCriteria_Then_Weak() throws Exception{
		assertStrength("abdefghi",PasswordStrength.WEEK);
	}

	@DisplayName("7. 숫자 포함 조건만 충족하는 경우")
	@Test
	public void meetsOnlyNumCriteria_Then_Weak() throws Exception{
		assertStrength("12345",PasswordStrength.WEEK);
	}

	@DisplayName("8. 대문자 포함 조건만 충족하는 경우")
	@Test
	public void meetsOnlyUpperCriteria_Then_Weak() throws Exception{
		assertStrength("ABZEF",PasswordStrength.WEEK);
	}

	private void assertStrength(String s, PasswordStrength expStr) {
		PasswordStrength result = meter.meter(s);
		assertEquals(result, expStr);
	}
}
