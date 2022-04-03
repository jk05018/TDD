package com.seunghan.vending_machine_tdd;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.seunghan.vending_machine_tdd.engine.ItemStorage;
import com.seunghan.vending_machine_tdd.engine.MoneyBox;
import com.seunghan.vending_machine_tdd.engine.util.RandomCoinGenerator;
import com.seunghan.vending_machine_tdd.io.InputConsole;
import com.seunghan.vending_machine_tdd.io.Input;
import com.seunghan.vending_machine_tdd.io.Output;
import com.seunghan.vending_machine_tdd.io.OutputConsole;

@SpringBootApplication
public class VendingMachineTddApplication {

	public static void main(String[] args) {
		Validator validator = new Validator();
		Input input = new InputConsole(validator);
		Output output = new OutputConsole();
		MoneyBox moneyBox = new MoneyBox(new RandomCoinGenerator());
		ItemStorage itemStorage = new ItemStorage();
		new VendingMachine(input, output, moneyBox, itemStorage).run();

	}

}
