package com.seunghan.vending_machine_tdd.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seunghan.vending_machine_tdd.Validator;

class ItemStorageTest {
	ItemStorage itemStorage;
	Validator validator = new Validator();

	@BeforeEach
	void setUp() {
		itemStorage = new ItemStorage();
	}

	@DisplayName("1. Item 정보를 입력하면 Storage에 저장되어야 한다.")
	@Test
	public void test() throws Exception {
		String[] info = validator.validateItems("[콜라,1500,20];[사이다,1000,10]");
		itemStorage.saveItemInfo(info);

		assertEquals(2, itemStorage.getItemSize());
	}

}
