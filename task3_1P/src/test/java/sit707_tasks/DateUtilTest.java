package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Ahsan Habib
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "224141207";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Aman Madaan";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}
	
	/*
	 * Complete below test cases.
	 */
	
	@Test
	public void testMinJanuary1ShouldIncrementToJanuary2() {
		// January 1st: Should increment to January 2nd
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldIncrementToJanuary2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testMinJanuary1ShouldDecrementToDecember31() {
		// January 1st: Should decrement to December 31st
		DateUtil date = new DateUtil(1, 1, 2024);
		System.out.println("january1ShouldDecrementToDecember31 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}
	
	/*
	 * Write tests for rest months of year 2024.
	 */

	/*February test case for leap year*/

	@Test
	public void testLeapYearFebruary29ShouldIncrementToMarch1() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testLeapYearFebruary29ShouldDecrementToFebruary28() {
		DateUtil date = new DateUtil(29, 2, 2024);
		date.decrement();
		Assert.assertEquals(28, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	/*
	 * March Test Cases
	 */
	@Test
	public void testMaxMarch31ShouldIncrementToApril1() {
		DateUtil date = new DateUtil(31, 3, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMaxMarch31ShouldDecrementToMarch30() {
		DateUtil date = new DateUtil(31, 3, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldIncrementToMarch2() {
		// January 1st: Should increment to January 2nd
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("march1ShouldIncrementToMarch2 > " + date);
		date.increment();
		System.out.println(date);
		Assert.assertEquals(2, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	@Test
	public void testMinMarch1ShouldDecrementToFeb29() {
		// January 1st: Should decrement to December 31st
		DateUtil date = new DateUtil(1, 3, 2024);
		System.out.println("march1ShouldDecrementToFeb29 > " + date);
		date.decrement();
		System.out.println(date);
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(2, date.getMonth());
	}

	/*
	 * April Test Cases
	 */
	@Test
	public void testMaxApril30ShouldIncrementToMay1() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}

	@Test
	public void testMaxApril30ShouldDecrementToApril29() {
		DateUtil date = new DateUtil(30, 4, 2024);
		date.decrement();
		Assert.assertEquals(29, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}

	@Test
	public void testMinApril1ShouldDecrementToMarch31() {
		DateUtil date = new DateUtil(1, 4, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(3, date.getMonth());
	}

	// May
	@Test
	public void testMaxMay31ShouldIncrementToJune1() {
		DateUtil date = new DateUtil(31, 5, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(6, date.getMonth());
	}

	@Test
	public void testMinMay1ShouldDecrementToApril30() {
		DateUtil date = new DateUtil(1, 5, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(4, date.getMonth());
	}

	//June
	@Test
	public void testMaxJune30ShouldIncrementToJuly1() {
		DateUtil date = new DateUtil(30, 6, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(7, date.getMonth());
	}

	@Test
	public void testMinJune1ShouldDecrementToMay31() {
		DateUtil date = new DateUtil(1, 6, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(5, date.getMonth());
	}

	// July

	@Test
	public void testMaxJuly31ShouldIncrementToAugust1() {
		DateUtil date = new DateUtil(31, 7, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(8, date.getMonth());
	}

	@Test
	public void testMinJuly1ShouldDecrementToJune30() {
		DateUtil date = new DateUtil(1, 7, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(6, date.getMonth());
	}

	//August
	@Test
	public void testMaxAugust31ShouldIncrementToSeptember1() {
		DateUtil date = new DateUtil(31, 8, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(9, date.getMonth());
	}

	@Test
	public void testMinAugust1ShouldDecrementToJuly31() {
		DateUtil date = new DateUtil(1, 8, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(7, date.getMonth());
	}

	// September
	@Test
	public void testMaxSeptember30ShouldIncrementToOctober1() {
		DateUtil date = new DateUtil(30, 9, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(10, date.getMonth());
	}

	@Test
	public void testMinSeptember1ShouldDecrementToAugust31() {
		DateUtil date = new DateUtil(1, 9, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(8, date.getMonth());
	}

	//October
	@Test
	public void testMaxOctober31ShouldIncrementToNovember1() {
		DateUtil date = new DateUtil(31, 10, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(11, date.getMonth());
	}

	@Test
	public void testMinOctober1ShouldDecrementToSeptember30() {
		DateUtil date = new DateUtil(1, 10, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(9, date.getMonth());
	}

	//November
	@Test
	public void testMaxNovember30ShouldIncrementToDecember1() {
		DateUtil date = new DateUtil(30, 11, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(12, date.getMonth());
	}

	@Test
	public void testMinNovember1ShouldDecrementToOctober31() {
		DateUtil date = new DateUtil(1, 11, 2024);
		date.decrement();
		Assert.assertEquals(31, date.getDay());
		Assert.assertEquals(10, date.getMonth());
	}

	// December

	@Test
	public void testMaxDecember31ShouldIncrementToJanuary1() {
		DateUtil date = new DateUtil(31, 12, 2024);
		date.increment();
		Assert.assertEquals(1, date.getDay());
		Assert.assertEquals(1, date.getMonth());
		Assert.assertEquals(2025, date.getYear());
	}

	@Test
	public void testMinDecember1ShouldDecrementToNovember30() {
		DateUtil date = new DateUtil(1, 12, 2024);
		date.decrement();
		Assert.assertEquals(30, date.getDay());
		Assert.assertEquals(11, date.getMonth());
	}

	/*
	 * Nominal Test Cases for Each Month
	 */
	@Test
	public void testNominalFebruaryLeapYear() {
		int rand_day_1_to_29 = 1 + new Random().nextInt(29);
		DateUtil date = new DateUtil(rand_day_1_to_29, 2, 2024);
		date.increment();
	}

	@Test
	public void testNominalMarch() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 3, 2024);
		date.increment();
	}

	@Test
	public void testNominalApril() {
		int rand_day_1_to_30 = 1 + new Random().nextInt(30);
		DateUtil date = new DateUtil(rand_day_1_to_30, 4, 2024);
		date.increment();
	}

	@Test
	public void testNominalMay() {
		int rand_day = 2 + new Random().nextInt(30); // Random day between 2 and 30
		DateUtil date = new DateUtil(rand_day, 5, 2024);
		date.increment();
	}

	@Test
	public void testNominalJune() {
		int rand_day = 2 + new Random().nextInt(29);
		DateUtil date = new DateUtil(rand_day, 6, 2024);
		date.increment();
	}

	@Test
	public void testNominalJuly() {
		int rand_day = 2 + new Random().nextInt(30);
		DateUtil date = new DateUtil(rand_day, 7, 2024);
		date.increment();
	}

	@Test
	public void testNominalAugust() {
		int rand_day = 2 + new Random().nextInt(30);
		DateUtil date = new DateUtil(rand_day, 8, 2024);
		date.increment();
	}

	@Test
	public void testNominalSeptember() {
		int rand_day = 2 + new Random().nextInt(29);
		DateUtil date = new DateUtil(rand_day, 9, 2024);
		date.increment();
	}

	@Test
	public void testNominalOctober() {
		int rand_day = 2 + new Random().nextInt(30);
		DateUtil date = new DateUtil(rand_day, 10, 2024);
		date.increment();
	}

	@Test
	public void testNominalNovember() {
		int rand_day = 2 + new Random().nextInt(29);
		DateUtil date = new DateUtil(rand_day, 11, 2024);
		date.increment();
	}

	@Test
	public void testNominalDecember() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
		DateUtil date = new DateUtil(rand_day_1_to_31, 12, 2024);
		date.increment();
	}

}
