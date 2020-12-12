package com.devatoms.hackerRank.algorithms.implementation.circularArrayRotation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(circularArrayRotation(new int[]{1}, 0, new int[]{0})).isEqualTo(new int[]{1});
		assertThat(circularArrayRotation(new int[]{1, 2}, 1, new int[]{0, 1})).isEqualTo(new int[]{2, 1});
		assertThat(circularArrayRotation(new int[]{1, 2}, 2, new int[]{0, 1})).isEqualTo(new int[]{1, 2});
		assertThat(circularArrayRotation(new int[]{1, 2, 3}, 2, new int[]{0, 1, 2})).isEqualTo(new int[]{2, 3, 1});
	}

	static int[] circularArrayRotation(int[] a, int k, int[] queries) {
		int[] b = new int[a.length];
		for (int i = 0; i < a.length; i++)
			b[(i + k) % a.length] = a[i];

		int[] res = new int[queries.length];
		for (int i = 0; i < res.length; i++)
			res[i] = b[queries[i]];

		return res;
	}
}
