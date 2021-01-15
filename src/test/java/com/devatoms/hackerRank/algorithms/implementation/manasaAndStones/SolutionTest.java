package com.devatoms.hackerRank.algorithms.implementation.manasaAndStones;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(stones(1, 1, 1)).isEqualTo(new int[]{0});
		assertThat(stones(3, 1, 2)).isEqualTo(new int[]{2, 3, 4});
		assertThat(stones(4, 10, 100)).isEqualTo(new int[]{30, 120, 210, 300});
		assertThat(stones(4, 1, 1)).isEqualTo(new int[]{3});
	}

	static int[] stones(int n, int a, int b) {
		if (a == b)
			return new int[]{a * (n - 1)};

		int min = 0, max = 0;
		int[] res = new int[n];

		if (a <= b) {
			min = a;
			max = b;
		} else {
			min = b;
			max = a;
		}

		for (int i = 0; i < n; i++)
			res[i] = (n - 1 - i) * min + i * max;

		return res;
	}
}
