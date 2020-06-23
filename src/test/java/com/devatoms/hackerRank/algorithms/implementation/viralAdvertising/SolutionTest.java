package com.devatoms.hackerRank.algorithms.implementation.viralAdvertising;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void ancillary() {
		assertThat(Math.pow(3, 2)).isEqualTo(9);
	}

	@Test
	public void solution() {
		assertThat(viralAdvertising(1)).isEqualTo(2);
		assertThat(viralAdvertising(2)).isEqualTo(5);
		assertThat(viralAdvertising(3)).isEqualTo(9);
		assertThat(viralAdvertising(4)).isEqualTo(15);
		assertThat(viralAdvertising(5)).isEqualTo(24);
	}

	static int viralAdvertising(int n) {
		int shared = 5;
		int liked = shared / 2;
		int count = liked;

		for (int i = 1; i < n; i++) {
			shared = liked * 3;
			liked = shared / 2;
			count += liked;
		}

		return count;
	}
}
