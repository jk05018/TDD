package com.seunghan.vending_machine_tdd;

import com.seunghan.vending_machine_tdd.exception.CoinException;
import com.seunghan.vending_machine_tdd.io.Input;
import com.seunghan.vending_machine_tdd.io.Output;

public class VendingMachine implements Runnable{
	private final Input input;
	private final Output output;

	public VendingMachine(Input input, Output output) {
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		enterMachineMoney();
	}

	private int enterMachineMoney() {
		while(true){
			try{
				output.print("자판기가 보유하고 있는 금액을 입력해 주세요.");
				return input.enterCurrentlyHaveMoney();
			}catch (IllegalArgumentException e){
				System.out.println(e.getMessage());
			}catch (CoinException e){
				System.out.println(e.getMessage());
			}
		}

	}
}
