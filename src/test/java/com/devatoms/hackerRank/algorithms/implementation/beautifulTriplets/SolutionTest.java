package com.devatoms.hackerRank.algorithms.implementation.beautifulTriplets;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(beautifulTriplets(1, new int[]{0})).isEqualTo(0);
		assertThat(beautifulTriplets(1, new int[]{1, 2, 3})).isEqualTo(1);
		assertThat(beautifulTriplets(1, new int[]{1, 2, 3, 4})).isEqualTo(2);
	}

	static int beautifulTriplets(int d, int[] arr) {
		int res = 0;

		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (arr[j] - arr[i] == d)
					for (int k = j + 1; k < arr.length; k++)
						if (arr[k] - arr[j] == d)
							res++;

		return res;
	}
}
