package com.devatoms.hackerRank.algorithms.implementation.fairRations;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(fairRations(new int[]{1, 1})).isEqualTo(2);
		assertThat(fairRations(new int[]{1, 2})).isEqualTo(-1);
		assertThat(fairRations(new int[]{1, 2, 3})).isEqualTo(4);
		assertThat(fairRations(new int[]{4, 5, 6, 7})).isEqualTo(4);
		assertThat(fairRations(new int[]{2, 3, 4, 5, 6})).isEqualTo(4);
	}

	static int fairRations(int[] B) {
		int loavesToGive = 0;

		for (int i = 0; i < B.length - 1; i++) {
			if (B[i] % 2 != 0) {
				B[i + 1]++;
				loavesToGive += 2;
			}
		}

		return B[B.length - 1] % 2 == 0 ? loavesToGive : -1;
	}
}
