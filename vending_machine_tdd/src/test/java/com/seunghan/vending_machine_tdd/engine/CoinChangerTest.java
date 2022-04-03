package com.seunghan.vending_machine_tdd.engine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.seunghan.vending_machine_tdd.engine.util.CoinChanger;
import com.seunghan.vending_machine_tdd.engine.value.Coin;

class CoinChangerTest {
	CoinChanger changer = new CoinChanger();

	@DisplayName("1. 정수가 입력되면 그에 맞는 가장 큰 coin으로 반환해야 한다")
	@Test
	public void enter_int_then_return_largest_available_coin() throws Exception{
		assertEquals(Coin.COIN_10,changer.moneyToCoin(20));
		assertEquals(Coin.COIN_50,changer.moneyToCoin(90));
		assertEquals(Coin.COIN_500,changer.moneyToCoin(5000));
		assertEquals(Coin.COIN_100,changer.moneyToCoin(450));
		assertEquals(Coin.COIN_50,changer.moneyToCoin(70));
	}

}
