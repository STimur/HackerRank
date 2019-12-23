package com.devatoms.hackerRank.interviewPreparationKit.sorting.markAndToys;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	private Object[] testData() {
		return new Object[] {
				new Object[]{new int[]{2}, 1, 0},
				new Object[]{new int[]{1}, 1, 1},
				new Object[]{new int[]{1, 1}, 2, 2},
				new Object[]{new int[]{1, 2}, 2, 1},
		};
	}

	@Test
	@Parameters(method = "testData")
	public void maximumToys(int[] prices, int moneyAmount, int toysBuyed) {
		assertThat(maximumToys(prices, moneyAmount), is(toysBuyed));
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
