package com.seunghan.vending_machine_tdd.io;

import java.util.Scanner;

import com.seunghan.vending_machine_tdd.Validator;

public class InputConsole implements Input{
	private final Scanner scanner = new Scanner(System.in);
	private Validator validator;

	public InputConsole(Validator validator) {
		this.validator = validator;
	}

	@Override
	public int enterCurrentlyHaveMoney() {
		String input = scanner.next();
		return validator.validateCurrentlyHaveMoney(input);
	}



}
