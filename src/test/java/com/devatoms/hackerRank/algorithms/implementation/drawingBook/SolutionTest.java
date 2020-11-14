package com.devatoms.hackerRank.algorithms.implementation.drawingBook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(pageCount(1, 1)).isEqualTo(0);
		assertThat(pageCount(4, 2)).isEqualTo(1);
		assertThat(pageCount(6, 5)).isEqualTo(1);
		assertThat(pageCount(7, 6)).isEqualTo(0);
	}

	static int pageCount(int n, int p) {
		if (p != 1 && p < n) {
			int fromBegin = p / 2;
			int fromEnd = 0;
			if (n % 2 == 0)
				fromEnd = (n - p + 1) / 2;
			else
				fromEnd = (n - p) / 2;
			return Math.min(fromBegin, fromEnd);
		}
		return 0;
	}
}
