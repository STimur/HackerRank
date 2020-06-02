package com.devatoms.hackerRank.algorithms.strings.weightedUniformStrings;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(weightedUniformStrings("", new int[]{0})).isEqualTo(new String[]{});
	}

	static String[] weightedUniformStrings(String s, int[] queries) {
		return new String[]{};
	}
}
