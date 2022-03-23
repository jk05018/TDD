package me.develop_han.TDD_start;

import java.time.LocalDate;

/**
 * 서적에서는 빌더 패턴으로 구현했으나 본인은 정적 팩터리 메서드를 사용해 구현
 */
public class PayData {
	private LocalDate firstBillingDate;
	private LocalDate billingDate;
	private int paymentAmount;

	public PayData() {
	}

	public PayData(LocalDate billingDate, int paymentAmount) {
		this.billingDate = billingDate;
		this.paymentAmount = paymentAmount;
	}

	public LocalDate getFirstBillingDate() { return firstBillingDate; }

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public int getPaymentAmount() {
		return paymentAmount;
	}

	public static Builder builder(){
		return new Builder();
	}
	public static class Builder{
		private PayData payData = new PayData();

		public Builder firstBillingDate(LocalDate firstBillingDate){
			payData.firstBillingDate = firstBillingDate;
			return this;
		}

		public Builder billingDate(LocalDate billingDate){
			payData.billingDate = billingDate;
			return this;
		}

		public Builder payAmount(int payAmount){
			payData.paymentAmount = payAmount;
			return this;
		}

		public PayData build(){
			return this.payData;
		}
	}
}
