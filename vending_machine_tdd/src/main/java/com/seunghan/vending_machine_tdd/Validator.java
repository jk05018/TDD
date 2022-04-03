package com.seunghan.vending_machine_tdd;

import com.seunghan.vending_machine_tdd.exception.CoinException;

public class Validator {
	/**
	 * 현재 자판기에 있는 돈을 유효성 검사하고 정수 값으로 반환하는 메서드
	 *
	 * @param input
	 * @return
	 * @throws IllegalArgumentException // 만약 money가 integer가 아닐 경우
	 */
	public int validateCurrentlyHaveMoney(String input){
		int money;
		try{
			money = Integer.parseInt(input);
		}catch (IllegalArgumentException e){
			throw new IllegalArgumentException("[ERROR] 입력은 정수여야 합니다.");
		}

		if(money % 10 != 0){
			throw new CoinException("[ERROR] 금액은 10원 단위로 입력되어야 합니다");
		}
		return money;
	}
}
