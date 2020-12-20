package com.devatoms.hackerRank.algorithms.implementation.beautifulDays;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(beautifulDays(20, 23, 6)).isEqualTo(2);
	}

	@Test
	public void ancillary() {
		assertThat(reverse(1)).isEqualTo(1);
		assertThat(reverse(2)).isEqualTo(2);
		assertThat(reverse(10)).isEqualTo(1);
		assertThat(reverse(5020)).isEqualTo(205);
		assertThat(reverse(9123)).isEqualTo(3219);
	}

	static int beautifulDays(int i, int j, int k) {
		int count = 0;

		for (int l = i; l <= j; l++)
			if (Math.abs(l - reverse(l)) % k == 0)
				count++;

		return count;
	}

	private static int reverse(int i) {
		int res = 0;

		while (i != 0) {
			res = res * 10 + i % 10;
			i /= 10;
		}

		return res;
	}
}
