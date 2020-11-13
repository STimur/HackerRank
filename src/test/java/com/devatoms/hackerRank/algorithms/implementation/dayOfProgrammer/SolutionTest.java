package com.devatoms.hackerRank.algorithms.implementation.dayOfProgrammer;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(dayOfProgrammer(1700)).isEqualTo("12.09.1700");
		assertThat(dayOfProgrammer(1917)).isEqualTo("13.09.1917");
		assertThat(dayOfProgrammer(1918)).isEqualTo("26.09.1918");
		assertThat(dayOfProgrammer(1919)).isEqualTo("13.09.1919");
		assertThat(dayOfProgrammer(2000)).isEqualTo("12.09.2000");
	}

	static String dayOfProgrammer(int year) {
		if (year < 1918)
			if (year % 4 == 0)
				return "12.09." + year;
			else
				return "13.09." + year;

		else if (year == 1918)
			return "26.09.1918";

		else if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0)))
			return "12.09." + year;
		else
			return "13.09." + year;
	}
}
