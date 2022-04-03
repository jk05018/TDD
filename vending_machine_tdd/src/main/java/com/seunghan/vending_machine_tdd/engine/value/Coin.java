package com.seunghan.vending_machine_tdd.engine.value;

import java.util.Arrays;
import java.util.Comparator;

public enum Coin {
	COIN_500(500),
	COIN_100(100),
	COIN_50(50),
	COIN_10(10);

	private final int amount;

	Coin(int amount) {
		this.amount = amount;
	}

	public static Coin getCoin(int money) {
		return Arrays.stream(Coin.values())
			.sorted(Comparator.comparing(Coin::getAmount, Comparator.reverseOrder()))
			.filter(c -> c.getAmount() < money)
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException());
	}

	public static int findMinimumCoin() {
		return Arrays.stream(Coin.values())
			.mapToInt(Coin::getAmount)
			.min().getAsInt();
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "Coin{" +
			"amount=" + amount +
			'}';
	}
}
