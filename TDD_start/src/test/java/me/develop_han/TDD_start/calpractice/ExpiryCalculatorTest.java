package me.develop_han.TDD_start.calpractice;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpiryCalculatorTest {

	// 매달 비용을 지불해야 사용할 수 있는 유료 서비스

	@DisplayName("1. 만원을 지불하면 납부일 기준으로 한달 뒤 서비스 만료일이 된다")
	@Test
	public void pay_10000_expiry_after_one_month() throws Exception {
		assertExqiryDate(PayData.builder()
			.billingDate(LocalDate.of(2021, 1, 2))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 2, 2));
		assertExqiryDate(PayData.builder()
			.billingDate(LocalDate.of(2021, 1, 3))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 2, 3));
	}

	@DisplayName("2. 만약 다음달에 한달 전 날짜가 존재하지 않다면 그 달의 마지막 날이 되어야 한다.")
	@Test
	public void if_next_month_dayOfMonth_not_exist_then_last_day() throws Exception {
		assertExqiryDate(PayData.builder()
			.billingDate(LocalDate.of(2021, 1, 31))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 2, 28));
		assertExqiryDate(PayData.builder()
			.billingDate(LocalDate.of(2021, 5, 31))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 6, 30));
	}

	@DisplayName("3. 만료되는 날에 만원을 납부하면 첫 날 일자를 따라간다")
	@Test
	public void test3() throws Exception {
		assertExqiryDate(PayData.builder()
			.firstBillingDate(LocalDate.of(2021, 1, 31))
			.billingDate(LocalDate.of(2021, 2, 28))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 3, 31));

		assertExqiryDate(PayData.builder()
			.firstBillingDate(LocalDate.of(2021, 3, 31))
			.billingDate(LocalDate.of(2021, 4, 30))
			.payAmount(10000)
			.build(), LocalDate.of(2021, 5, 31));

	}

	@DisplayName("4. 만원 이상의 돈을 내면 그만큼 결제가 된다.")
	@Test
	public void test4() throws Exception {
		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2021, 1, 31))
				.billingDate(LocalDate.of(2021, 1, 31))
				.payAmount(20000).build()
			, LocalDate.of(2021, 3, 31));

		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2021, 1, 31))
				.billingDate(LocalDate.of(2021, 1, 31))
				.payAmount(30000).build()
			, LocalDate.of(2021, 4, 30));

		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2021, 7, 31))
				.billingDate(LocalDate.of(2021, 7, 31))
				.payAmount(20000).build()
			, LocalDate.of(2021, 9, 30));
	}

	@DisplayName("5. 10개월의 요금을 납부하면 1년 제공")
	@Test
	public void pay_10_months_then_expiry_after_1year() throws Exception{
		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2021, 7, 31))
				.billingDate(LocalDate.of(2021, 7, 31))
				.payAmount(100000).build()
			, LocalDate.of(2022, 7, 31));

		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2021, 1, 31))
				.billingDate(LocalDate.of(2021, 1, 31))
				.payAmount(100000).build()
			, LocalDate.of(2022, 1, 31));

		// 예외 윤년일 경우 1년 뒤 2/28 되어야함
		assertExqiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2020, 2, 29))
				.billingDate(LocalDate.of(2020, 2, 29))
				.payAmount(100000).build()
			, LocalDate.of(2021, 2, 28));
	}
	private void assertExqiryDate(PayData payData, LocalDate expectedDate) {
		ExpiryCalculator calculator = new ExpiryCalculator();
		LocalDate expiryDate = calculator.calculate(payData);

		Assertions.assertEquals(expectedDate, expiryDate);
	}
}
