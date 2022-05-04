package me.develop_han.TDD_start.programmers;

public class PhoneNumber {
	private String value;

	public PhoneNumber(String value) {
		this.value = value;

	}

	public String toStringWithDash() {
		if(this.value.length() < 11){
			return this.value.substring(0, 3) + "-" + value.substring(3, 6) + "-" + value.substring(6);
		}
		return this.value.substring(0, 3) + "-" + value.substring(3, 7) + "-" + value.substring(7);
	}

	public String toStringWithoutDash() {
		return this.value;
	}
}
