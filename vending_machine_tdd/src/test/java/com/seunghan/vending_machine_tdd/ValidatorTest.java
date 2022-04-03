package com.seunghan.vending_machine_tdd;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
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

	@DisplayName("3. 상품 입력은 [콜라,1500,20];[사이다,1000,10]의 형태를 가져야 한다.")
	@Test
	public void item_validate_One_Item_test() throws Exception{
		String[] itemList = validator.validateItems("[콜라,1500,20]");
		assertEquals("콜라,1500,20",itemList[0]);
		itemList = validator.validateItems("[사이다,1000,10]");
		assertEquals("사이다,1000,10",itemList[0]);
		assertThrows(IllegalArgumentException.class, () -> validator.validateItems("콜라,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> validator.validateItems("[,1500,20]"));
		assertThrows(IllegalArgumentException.class, () -> validator.validateItems("콜라,15,20]"));
		assertThrows(IllegalArgumentException.class, () -> validator.validateItems("[콜라,1500,2"));
		assertThrows(IllegalArgumentException.class, () -> validator.validateItems("콜라,,20]"));

	}

	@DisplayName("1. 테스트")
	@Test
	public void test() throws Exception{
		assertDoesNotThrow(() -> validator.validateItems("[콜라,1500,20];[사이다,1000,10]"));

	}




}
