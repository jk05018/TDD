package com.seunghan.vending_machine_tdd.engine;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.seunghan.vending_machine_tdd.engine.value.Item;

public class ItemStorage {
	private Map<Item, Integer> items = new HashMap<>();

	public void saveItemInfo(String[] itemInfo) {
		Arrays.stream(itemInfo).map(s -> s.split(","))
			.forEach(s -> items.put(Item.valueOf(s[0], Integer.parseInt(s[1])), Integer.parseInt(s[2])));
	}

	public int getMinimumPrice() {
		return items.keySet().stream()
			.mapToInt(Item::getPrice)
			.min()
			.getAsInt();
	}

	public boolean canBuyAnything(){
		for (int i : items.values()) {
			if(i != 0){
				return true;
			}
		}
		return false;
	}

	public int buyItem(String name,int money){
		Item item = items.keySet().stream().filter(i -> i.getName().equals(name))
			.findAny()
			.orElseThrow(() -> new IllegalArgumentException());
		if(item.getPrice() <= money && items.get(item) > 0){
			items.put(item,items.get(item) - 1);
		}else{
			throw new IllegalArgumentException();
		}

		return money - item.getPrice();
	}

	public int getItemSize() {
		return items.size();
	}

}
