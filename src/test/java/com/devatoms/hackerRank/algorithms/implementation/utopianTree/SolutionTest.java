package com.devatoms.hackerRank.algorithms.implementation.utopianTree;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(utopianTree(0)).isEqualTo(1);
		assertThat(utopianTree(1)).isEqualTo(2);
		assertThat(utopianTree(3)).isEqualTo(6);
	}

	static int utopianTree(int n) {
		int height = 1;

		for (int i = 1; i <= n; i++)
			if (i % 2 == 0)
				height++;
			else
				height *= 2;

		return height;
	}
}
