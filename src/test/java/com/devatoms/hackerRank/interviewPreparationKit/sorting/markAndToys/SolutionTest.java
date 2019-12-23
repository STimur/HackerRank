package com.devatoms.hackerRank.interviewPreparationKit.sorting.markAndToys;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void dummy() {
		assertThat(maximumToys(new int[]{2}, 1), is(0));
		assertThat(maximumToys(new int[]{1}, 1), is(1));
		assertThat(maximumToys(new int[]{1, 1}, 2), is(2));
		assertThat(maximumToys(new int[]{1, 2}, 2), is(1));
	}

	static int maximumToys(int[] prices, int k) {
		int ans = 0;

		for (int i = 0; i < prices.length; i++)
			if (prices[i] <= k) {
				ans++;
				k -= prices[i];
			}

		return ans;
	}
}
