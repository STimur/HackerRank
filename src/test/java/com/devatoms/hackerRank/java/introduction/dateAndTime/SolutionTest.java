package com.devatoms.hackerRank.java.introduction.dateAndTime;

import org.junit.Test;

import java.util.Calendar;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(findDay(5, 18, 2020), is("MONDAY"));
		assertThat(findDay(5, 21, 2020), is("THURSDAY"));
		assertThat(findDay(8, 5, 2015), is("WEDNESDAY"));
	}

	@Test
	public void calendar() {
		assertThat(Calendar.JANUARY, is(0));
		assertThat(Calendar.MAY, is(4));
		assertThat(Calendar.DECEMBER, is(11));
		assertThat(Calendar.MONDAY, is(2));
	}

	/*
	 * Complete the 'findDay' function below.
	 *
	 * The function is expected to return a STRING.
	 * The function accepts following parameters:
	 *  1. INTEGER month
	 *  2. INTEGER day
	 *  3. INTEGER year
	 */

	public static String findDay(int month, int day, int year) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, day);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
			case 1:
				return "SUNDAY";
			case 2:
				return "MONDAY";
			case 3:
				return "TUESDAY";
			case 4:
				return "WEDNESDAY";
			case 5:
				return "THURSDAY";
			case 6:
				return "FRIDAY";
			case 7:
				return "SATURDAY";
		}
		return null;
	}
}
