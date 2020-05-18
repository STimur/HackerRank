package com.devatoms.hackerRank.algorithms.strings.gameOfThronesOne;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(gameOfThrones("a"), is("YES"));
		assertThat(gameOfThrones("ab"), is("NO"));
	}

	static String gameOfThrones(String s) {
		if (s.length() == 1)
			return "YES";
		return "NO";
	}
}
