package com.devatoms.hackerRank.algorithms.implementation.halloweenSale;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(howManyGames(20, 3, 6, 70)).isEqualTo(5);
		assertThat(howManyGames(20, 3, 6, 80)).isEqualTo(6);
		assertThat(howManyGames(20, 3, 6, 85)).isEqualTo(7);
	}

	static int howManyGames(int p, int d, int m, int s) {
		int count = 0;

		while (true) {
			if (s - p >= 0) {
				s -= p;
				count++;
			} else
				break;
			if (p - d >= m)
				p -= d;
			else
				p = m;
		}

		return count;
	}

}
