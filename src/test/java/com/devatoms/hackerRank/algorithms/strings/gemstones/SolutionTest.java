package com.devatoms.hackerRank.algorithms.strings.gemstones;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(gemstones(new String[]{"a", "a"})).isEqualTo(1);
	}

	static int gemstones(String[] arr) {
		return 1;
	}
}
