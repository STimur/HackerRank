package com.devatoms.hackerRank.algorithms.implementation.equalizeTheArray;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(equalizeArray(new int[]{1})).isEqualTo(0);
		assertThat(equalizeArray(new int[]{1, 2})).isEqualTo(1);
		assertThat(equalizeArray(new int[]{1, 1})).isEqualTo(0);
		assertThat(equalizeArray(new int[]{1, 1, 2, 2})).isEqualTo(2);
		assertThat(equalizeArray(new int[]{1, 1, 2, 2, 2})).isEqualTo(2);
		assertThat(equalizeArray(new int[]{3, 3, 2, 1, 3})).isEqualTo(2);
		int[] allInts = new int[100];
		for (int i = 0; i < allInts.length; i++)
			allInts[i] = i + 1;
		assertThat(equalizeArray(allInts)).isEqualTo(99);
	}

	static int equalizeArray(int[] arr) {
		if (arr.length == 1)
			return 0;

		final int[] counts = new int[101];
		int res = 0;

		for (int i : arr)
			counts[i]++;

		Arrays.sort(counts, 1, 101);

		for (int i = 1; i < counts.length - 1; i++)
			if (counts[i] != 0)
				res += counts[i];

		return res;
	}
}
