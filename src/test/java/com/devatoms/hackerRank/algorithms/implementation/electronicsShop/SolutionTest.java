package com.devatoms.hackerRank.algorithms.implementation.electronicsShop;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(getMoneySpent(new int[]{1}, new int[]{1}, 1)).isEqualTo(-1);
		assertThat(getMoneySpent(new int[]{1}, new int[]{1}, 2)).isEqualTo(2);
		assertThat(getMoneySpent(new int[]{1, 2}, new int[]{1}, 3)).isEqualTo(3);
	}

	static int getMoneySpent(int[] keyboards, int[] drives, int b) {
		int max = 0;
		for (int i = 0; i < keyboards.length; i++)
			for (int j = 0; j < drives.length; j++)
				if (keyboards[i] + drives[j] > max && keyboards[i] + drives[j] <= b)
					max = keyboards[i] + drives[j];

		return max == 0 ? -1 : max;
	}
}
