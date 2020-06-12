package com.devatoms.hackerRank.algorithms.warmup.timeConversion;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(timeConversion("12:00:00PM")).isEqualTo("12:00:00");
		assertThat(timeConversion("12:00:00AM")).isEqualTo("00:00:00");
		assertThat(timeConversion("07:05:45PM")).isEqualTo("19:05:45");
	}

	static String timeConversion(String s) {
		String[] tokens = s.substring(0, 8).split(":");
		int hours = Integer.valueOf(tokens[0]);
		int mins = Integer.valueOf(tokens[1]);
		int secs = Integer.valueOf(tokens[2]);
		boolean isAM = s.substring(8).equals("AM");

		if (isAM) {
			if (hours == 12)
				hours = 0;
			return String.format("%02d:%02d:%02d", hours, mins, secs);
		}
		if (hours != 12)
			hours += 12;

		return String.format("%02d:%02d:%02d", hours, mins, secs);
	}
}
