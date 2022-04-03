package com.seunghan.vending_machine_tdd.engine.value;

import java.util.Objects;

public class Item {
	private String name;
	private int price;

	private Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public static Item valueOf(String name, int price){
		return new Item(name, price);
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Item item = (Item)o;
		return getPrice() == item.getPrice() && Objects.equals(getName(), item.getName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPrice());
	}

	@Override
	public String toString() {
		return "Item{" +
			"name='" + name + '\'' +
			", price=" + price +
			'}';
	}
}
