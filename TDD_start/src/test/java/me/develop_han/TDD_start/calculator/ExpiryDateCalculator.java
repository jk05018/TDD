package me.develop_han.TDD_start.calculator;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {

	public LocalDate calculateExpiryDate(PayData payData) {
		int addedMonths = payData.getPaymentAmount() == 100000 ?
			12 : payData.getPaymentAmount() / 10000;
		if (payData.getFirstBillingDate() != null) {
			return expiryDateUsingFirstBillingDate(payData, addedMonths);
		} else {
			return payData.getBillingDate().plusMonths(addedMonths);
		}
	}

	private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
		LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
		if (!isSameDayOfMonth(candidateExp, payData.getFirstBillingDate())) {
			final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
			final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
			if (dayLenOfCandiMon < dayOfFirstBilling) {
				return candidateExp.withDayOfMonth(dayLenOfCandiMon);
			}
			return candidateExp.withDayOfMonth(dayOfFirstBilling);
		} else {
			return candidateExp;
		}
	}

	private boolean isSameDayOfMonth(LocalDate candidateExp, LocalDate dayOfFirstBilling) {
		return dayOfFirstBilling.getDayOfMonth() == candidateExp.getDayOfMonth();
	}

}
