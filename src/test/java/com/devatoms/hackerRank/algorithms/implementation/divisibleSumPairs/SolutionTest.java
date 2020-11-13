package com.devatoms.hackerRank.algorithms.implementation.divisibleSumPairs;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(divisibleSumPairs(2, 1, new int[]{1, 1})).isEqualTo(1);
		assertThat(divisibleSumPairs(2, 2, new int[]{1, 1})).isEqualTo(1);
		assertThat(divisibleSumPairs(3, 2, new int[]{1, 1, 1})).isEqualTo(3);
		assertThat(divisibleSumPairs(4, 2, new int[]{1, 1, 1, 1})).isEqualTo(6);
		assertThat(divisibleSumPairs(4, 1, new int[]{1, 1, 1, 1})).isEqualTo(6);
	}

	static int divisibleSumPairs(int n, int k, int[] ar) {
		if (k == 1)
			return (n * n - n) / 2;

		int count = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if ((ar[i] + ar[j]) % k == 0)
					count++;
			}
		}
		return count;
	}
}
