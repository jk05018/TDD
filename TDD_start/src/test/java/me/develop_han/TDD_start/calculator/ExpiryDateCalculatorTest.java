package me.develop_han.TDD_start.calculator;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExpiryDateCalculatorTest {

	@DisplayName("1. 만원 납부하면 한달 뒤가 만료일이 됨")
	@Test
	public void oneMonth_pay_10000() throws Exception {
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2019,3,1))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 4, 1));
		assertExpiryDate(PayData.builder()
				.billingDate(LocalDate.of(2019,5,5))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 6, 5));
	}

	@DisplayName("2. 납부일과 한달뒤가 일치하지 않음")
	@Test
	public void test2() throws Exception {
		//납부일이 2019-01-31 , 만기일이 2019-02-28
		assertExpiryDate(PayData.builder().billingDate(LocalDate.of(2019, 1, 31))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 2, 28));
		// 납부일이 2019-05-31, 만기일이 2019-06-30
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2019, 5, 31))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 6, 30));
		// 납부일이 2020-01-31, 만기일이 2019-02-29
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2020, 1, 31))
			.payAmount(10000)
			.build(),
			LocalDate.of(2020, 2, 29));
	}

	@DisplayName("3. 첫 납부일과 만료일 일자가 다를 때 만원 납부")
	@Test
	public void test3() throws Exception {
		assertExpiryDate(PayData.builder()
			.firstBillingDate(LocalDate.of(2019, 1, 30))
			.billingDate(LocalDate.of(2019, 2, 28))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 3, 30));

		assertExpiryDate(PayData.builder()
			.firstBillingDate(LocalDate.of(2019, 5, 31))
			.billingDate(LocalDate.of(2019, 6, 30))
			.payAmount(10000)
			.build(),
			LocalDate.of(2019, 7, 31));
	}

	@DisplayName("4. 2만원 이상 N만원을 지불하면 다음 만료일은 N달 뒤가 된다.")
	@Test
	public void pay_N10000_expire_after_NMonth() throws Exception{
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2019,3,1))
			.payAmount(20000)
			.build(),
			LocalDate.of(2019,5,1)

		);

		assertExpiryDate(PayData.builder()
				.billingDate(LocalDate.of(2019,3,1))
				.payAmount(30000)
				.build(),
			LocalDate.of(2019,6,1)

		);
	}

	@DisplayName("5. 첫 납부일과 만료일 일자가 ㅈ다를 때 2만원 이상 납부한 사례")
	@Test
	public void pay_N10000_and_not_equal() throws Exception{
		assertExpiryDate(PayData.builder()
			.firstBillingDate(LocalDate.of(2019,1,31))
				.billingDate(LocalDate.of(2019,2,28))
				.payAmount(20000)
				.build(),
			LocalDate.of(2019,4,30)
		);

		assertExpiryDate(PayData.builder()
				.firstBillingDate(LocalDate.of(2019,3,31))
				.billingDate(LocalDate.of(2019,4,30))
				.payAmount(30000)
				.build(),
			LocalDate.of(2019,7,31)
		);
	}

	@DisplayName("6. 10개월 요금을 납부하면 1년 제공")
	@Test
	public void pay_100000_one_month() throws Exception{
		assertExpiryDate(PayData.builder()
			.billingDate(LocalDate.of(2019,1,28))
			.payAmount(100000)
			.build()
			,LocalDate.of(2020,1,28)
			);

		assertExpiryDate(PayData.builder()
				.billingDate(LocalDate.of(2019,3,25))
				.payAmount(100000)
				.build()
			,LocalDate.of(2020,3,25)
		);
	}

	private void assertExpiryDate(PayData payData, LocalDate expectedDate) {
		ExpiryDateCalculator cal = new ExpiryDateCalculator();
		LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
		assertEquals(expectedDate, realExpiryDate);
	}
}
