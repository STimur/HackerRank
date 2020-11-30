package com.devatoms.hackerRank.algorithms.implementation.hurdleRace;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(hurdleRace(4, new int[]{1, 6, 3, 5, 2})).isEqualTo(2);
		assertThat(hurdleRace(1, new int[]{1, 2, 3, 3, 2})).isEqualTo(2);
		assertThat(hurdleRace(7, new int[]{2, 5, 4, 5, 2})).isEqualTo(0);
	}

	static int hurdleRace(int k, int[] height) {
		int max = Arrays.stream(height).max().getAsInt();
		if (k >= max)
			return 0;
		return max - k;
	}
}
