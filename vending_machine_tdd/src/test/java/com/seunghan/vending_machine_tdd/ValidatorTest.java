package com.seunghan.vending_machine_tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seunghan.vending_machine_tdd.exception.CoinException;

class ValidatorTest {
	Validator validator = new Validator();

	@DisplayName("1. vendingmachine의 잔고 값은 정수(int)로 입력 받아야 한다.")
	@Test
	public void enter_value_mustBe_integer() throws Exception{
		assertEquals(120,validator.validateCurrentlyHaveMoney("120"));
		assertEquals(340,validator.validateCurrentlyHaveMoney("340"));

		assertThrows(IllegalArgumentException.class,() -> {
			validator.validateCurrentlyHaveMoney("imseunghan");
		});

		assertThrows(IllegalArgumentException.class,() -> {
			validator.validateCurrentlyHaveMoney("너너나");
		});

	}
	@DisplayName("2. vendinMachine에 현재 저장되어 있는 금액은 최소 단위가 10 이여야 한다.")
	@Test
	public void vendingMachine_money_can_divided_by_10() throws Exception{
		assertEquals(100,validator.validateCurrentlyHaveMoney("100"));
		assertThrows(CoinException.class,() -> {
			validator.validateCurrentlyHaveMoney("101");
		});
	}




}
