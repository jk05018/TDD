package com.seunghan.vending_machine_tdd.engine;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import com.seunghan.vending_machine_tdd.engine.util.RandomCoinGenerator;
import com.seunghan.vending_machine_tdd.engine.value.Coin;

public class MoneyBox {
	private final RandomCoinGenerator randomCoinGenerator;
	private Map<Coin, Integer> box = new HashMap<>();

	public MoneyBox(RandomCoinGenerator randomCoinGenerator) {
		this.randomCoinGenerator = randomCoinGenerator;
	}

	public void fillTheMoneyBox(int money) {
		int minValue = Coin.findMinimumCoin();
		while (money >= minValue) {
			Coin coin = randomCoinGenerator.getRandomCoin();
			if (money >= coin.getAmount()) {
				box.put(coin, box.getOrDefault(coin, 0) + 1);
				money -= coin.getAmount();
			}
		}
	}

	public String getMoneyBoxStatus() {
		StringBuilder builder = new StringBuilder("자판기가 보유한 동전\n");
		box.keySet().stream()
			.sorted(Comparator.comparing(Coin::getAmount, Comparator.reverseOrder()))
			.forEach(c -> builder.append(c.getAmount() + "원 - " + box.get(c) + "개\n"));
		return builder.toString();
	}
}
