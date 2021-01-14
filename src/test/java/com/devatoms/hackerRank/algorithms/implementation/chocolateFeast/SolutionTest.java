package com.devatoms.hackerRank.algorithms.implementation.chocolateFeast;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(chocolateFeast(2, 2, 2)).isEqualTo(1);
		assertThat(chocolateFeast(2, 1, 2)).isEqualTo(3);
		assertThat(chocolateFeast(4, 1, 2)).isEqualTo(7);
		assertThat(chocolateFeast(8, 1, 2)).isEqualTo(15);
		assertThat(chocolateFeast(6, 2, 2)).isEqualTo(5);
	}

	static int chocolateFeast(int n, int c, int m) {
		int numOfChocolatesBought = n / c;
		int numOfWrappers = numOfChocolatesBought;
		int numOfBonusChocolates = 0;

		while (numOfWrappers / m > 0) {
			numOfBonusChocolates += numOfWrappers / m;
			numOfWrappers = numOfWrappers / m + numOfWrappers % m;
		}

		return numOfChocolatesBought + numOfBonusChocolates;
	}
}
