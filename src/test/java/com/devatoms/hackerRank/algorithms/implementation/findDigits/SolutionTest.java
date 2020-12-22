package com.devatoms.hackerRank.algorithms.implementation.findDigits;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(findDigits(0)).isEqualTo(0);
		assertThat(findDigits(10)).isEqualTo(1);
		assertThat(findDigits(1012)).isEqualTo(3);
	}

	static int findDigits(int n) {
		int temp = n;
		int divisor = 0;
		int count = 0;

		while (temp != 0) {
			divisor = temp % 10;
			if (divisor != 0 && n % divisor == 0)
				count++;
			temp /= 10;
		}

		return count;
	}
}
