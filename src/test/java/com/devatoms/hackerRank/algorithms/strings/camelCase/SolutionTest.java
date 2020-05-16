package com.devatoms.hackerRank.algorithms.strings.camelCase;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(camelcase("a"), is(1));
		assertThat(camelcase("aB"), is(2));
		assertThat(camelcase("aBC"), is(3));
		assertThat(camelcase("aBCDe"), is(4));
	}

	static int camelcase(String s) {
		int count = 1;
		for (Character c : s.toCharArray())
			if (Character.isUpperCase(c))
				count++;

		return count;
	}
}
