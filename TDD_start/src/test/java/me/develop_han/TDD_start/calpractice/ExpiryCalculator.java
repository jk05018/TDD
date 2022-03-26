package me.develop_han.TDD_start.calpractice;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryCalculator {

	public LocalDate calculate(PayData data) {
		int addedMonths = data.getPayAmount() / 10000;

		if(addedMonths == 10){
			addedMonths = 12;
		}

		if(data.getFirstBillingDate() != null){
			return expiryDateUsingFirstBillingDate(data, addedMonths);
		}

		return data.getBillingDate().plusMonths(addedMonths);
	}

	private LocalDate expiryDateUsingFirstBillingDate(PayData data, int addedMonths) {
		LocalDate nextDate = data.getBillingDate().plusMonths(addedMonths);

		final int dayOfFirstBillingDate = data.getFirstBillingDate().getDayOfMonth();
		if(dayOfFirstBillingDate != nextDate.getDayOfMonth()){
			final int dayLenOfCandidateMonth = YearMonth.from(nextDate).lengthOfMonth();
			if(dayLenOfCandidateMonth < dayOfFirstBillingDate){
				return nextDate.withDayOfMonth(dayLenOfCandidateMonth);
			}
			return nextDate.withDayOfMonth(dayOfFirstBillingDate);
		}else{
			return nextDate;
		}
	}
}
