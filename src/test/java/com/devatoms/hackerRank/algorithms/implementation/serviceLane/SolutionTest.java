package com.devatoms.hackerRank.algorithms.implementation.serviceLane;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(serviceLane(new int[]{2, 3, 1, 2, 3, 2, 3, 3},
				new int[][]{{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}})).isEqualTo(new int[]{1, 2, 3, 2, 1});
	}

	static int[] serviceLane(int[] width, int[][] cases) {
		int[] result = new int[cases.length];

		for (int i = 0; i < cases.length; i++) {
			int min = 3;
			for (int j = cases[i][0]; j <= cases[i][1]; j++)
				if (width[j] < min)
					min = width[j];
			result[i] = min;
		}

		return result;
	}
}
