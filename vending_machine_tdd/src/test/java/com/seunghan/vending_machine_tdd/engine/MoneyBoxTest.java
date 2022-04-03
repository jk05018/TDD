package com.seunghan.vending_machine_tdd.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seunghan.vending_machine_tdd.engine.util.RandomCoinGenerator;

class MoneyBoxTest {
	MoneyBox moneyBox;

	@BeforeEach
	public void setUp(){
		moneyBox = new MoneyBox(new RandomCoinGenerator());
	}
	@DisplayName("1. MoneyBox 상태 출력 테스트")
	@Test
	public void moneybox_status_test() throws Exception{

	}

}
