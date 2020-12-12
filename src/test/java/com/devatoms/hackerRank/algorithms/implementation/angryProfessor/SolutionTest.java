package com.devatoms.hackerRank.algorithms.implementation.angryProfessor;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(angryProfessor(3, new int[]{-1, -3, 4, 2})).isEqualTo("YES");
		assertThat(angryProfessor(2, new int[]{0, -1, 2, 1})).isEqualTo("NO");
	}

	static String angryProfessor(int k, int[] a) {
		int onTime = 0;

		for (int i = 0; i < a.length; i++)
			if (a[i] <= 0)
				onTime++;

		return onTime < k ? "YES" : "NO";
	}
}
