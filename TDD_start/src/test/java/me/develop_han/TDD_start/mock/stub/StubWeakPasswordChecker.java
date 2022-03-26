package me.develop_han.TDD_start.mock.stub;

public class StubWeakPasswordChecker implements WeakPasswordChecker{
	boolean weak;

	public void setWeak(boolean b) {
		this.weak = b;
	}

	@Override
	public boolean checkPasswordWeak(String password) {
		return weak;
	}
}
