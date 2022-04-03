package com.seunghan.vending_machine_tdd.io;

public interface Input {
	int enterCurrentlyHaveMoney();
	String[] enterItems();
	int enterBuyMoney();
	String enterItemName();
}
