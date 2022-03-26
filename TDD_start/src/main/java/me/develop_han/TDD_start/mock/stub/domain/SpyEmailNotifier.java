package me.develop_han.TDD_start.mock.stub.domain;

public class SpyEmailNotifier implements EmailNotifier{
	private boolean called;
	private String email;

	public boolean isCalled() {
		return called;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public void sendRegisterEmail(String email) {
		this.called = true;
		this.email = email;
	}
}
