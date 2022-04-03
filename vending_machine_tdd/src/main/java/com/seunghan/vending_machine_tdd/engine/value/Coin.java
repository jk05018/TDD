package com.seunghan.vending_machine_tdd.engine.value;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(int amount) {
		this.amount = amount;
	}
}
