package me.develop_han.TDD_start.join_tdd.stub.domain;

public class StubWeakPasswordChecker implements WeakPasswordChecker {
	public boolean weak;

	public void setWeak(boolean weak) {
		this.weak = weak;
	}

	@Override
	public boolean checkPasswordWeak(String pw) {
		return weak;
	}
}
