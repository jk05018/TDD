package com.seunghan.vending_machine_tdd;

import com.seunghan.vending_machine_tdd.engine.ItemStorage;
import com.seunghan.vending_machine_tdd.engine.MoneyBox;
import com.seunghan.vending_machine_tdd.exception.CoinException;
import com.seunghan.vending_machine_tdd.io.Input;
import com.seunghan.vending_machine_tdd.io.Output;

public class VendingMachine implements Runnable {
	private final Input input;
	private final Output output;
	private final MoneyBox moneyBox;
	private final ItemStorage itemStorage;

	public VendingMachine(Input input, Output output, MoneyBox moneyBox,
		ItemStorage itemStorage) {
		this.input = input;
		this.output = output;
		this.moneyBox = moneyBox;
		this.itemStorage = itemStorage;
	}

	@Override
	public void run() {
		moneyBox.fillTheMoneyBox(enterMachineMoney());
		output.print(moneyBox.getMoneyBoxStatus());
		String[] itemInformations = enterItemInfo();
		System.out.println(itemInformations);
		itemStorage.saveItemInfo(itemInformations);
		int remainMoney = buy();
		output.print(moneyBox.repayCoin(remainMoney));
	}

	private String[] enterItemInfo() {
		while (true){
			try{
				output.print("상품명과 가격, 수량을 입력해 주세요.");
				return input.enterItems();
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}
	}

	private int enterMachineMoney() {
		while (true) {
			try {
				output.print("자판기가 보유하고 있는 금액을 입력해 주세요.");
				return input.enterCurrentlyHaveMoney();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			} catch (CoinException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private int buy(){
		System.out.println("buy start");
		output.print("투입 금액을 입력해 주세요.");
		int money = input.enterBuyMoney();
		int minPrice = itemStorage.getMinimumPrice();
		while(money >= minPrice && itemStorage.canBuyAnything()){
			try{
				output.print("투입금액 : " + money);
				String item = input.enterItemName();
				money = itemStorage.buyItem(item,money);
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}
		}

		return money;
	}
}
