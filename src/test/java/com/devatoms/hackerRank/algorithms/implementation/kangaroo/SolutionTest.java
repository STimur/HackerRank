package com.devatoms.hackerRank.algorithms.implementation.kangaroo;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(kangaroo(0, 1, 1, 1)).isEqualTo("NO");
		assertThat(kangaroo(0, 2, 1, 1)).isEqualTo("YES");
		assertThat(kangaroo(0, 2, 1, 3)).isEqualTo("NO");
		assertThat(kangaroo(0, 3, 2, 2)).isEqualTo("YES");
	}

	static String kangaroo(int x1, int v1, int x2, int v2) {
		if (v1 <= v2)
			return "NO";

		if ((x2 - x1) % (v1 - v2) == 0)
			return "YES";

		return "NO";
	}
}
