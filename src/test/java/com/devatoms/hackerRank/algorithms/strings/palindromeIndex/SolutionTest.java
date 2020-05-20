package com.devatoms.hackerRank.algorithms.strings.palindromeIndex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(palindromeIndex("a"), is(-1));
	}

	static int palindromeIndex(String s) {
		return -1;
	}
}
