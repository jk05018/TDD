package com.seunghan.vending_machine_tdd.engine.util;

import java.util.Random;

import com.seunghan.vending_machine_tdd.engine.value.Coin;

public class RandomCoinGenerator {
	private final Coin[] coins = {Coin.COIN_500, Coin.COIN_100, Coin.COIN_50, Coin.COIN_10};
	private final Random random = new Random();

	public Coin getRandomCoin() {
		return coins[random.nextInt(4)];
	}

}
