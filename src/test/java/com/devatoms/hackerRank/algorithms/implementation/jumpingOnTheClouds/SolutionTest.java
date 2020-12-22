package com.devatoms.hackerRank.algorithms.implementation.jumpingOnTheClouds;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(jumpingOnClouds(new int[]{0, 0, 1, 0}, 2)).isEqualTo(96);
		assertThat(jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 1, 0}, 2)).isEqualTo(92);
	}

	static int jumpingOnClouds(int[] c, int k) {
		int e = 100;
		int i = 0;

		do {
			i = (i + k) % c.length;
			e--;
			if (c[i] == 1)
				e -= 2;
		} while (i != 0);

		return e;
	}
}
