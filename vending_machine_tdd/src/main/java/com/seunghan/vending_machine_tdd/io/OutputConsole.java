package com.seunghan.vending_machine_tdd.io;

public class OutputConsole implements Output{
	@Override
	public void print(String context) {
		System.out.println(context);
	}
}
