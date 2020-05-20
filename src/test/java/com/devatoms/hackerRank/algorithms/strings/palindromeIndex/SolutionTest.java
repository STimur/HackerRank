package com.devatoms.hackerRank.algorithms.strings.palindromeIndex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(palindromeIndex("a"), is(-1));
		assertThat(palindromeIndex("ab"), is(0));
		assertThat(palindromeIndex("aba"), is(-1));
	}

	@Test
	public void string_builder() {
		assertThat(new StringBuilder("ab").reverse().toString(), is("ba"));
		assertThat(new StringBuilder("ab").deleteCharAt(0).toString(), is("b"));
	}

	static int palindromeIndex(String s) {
		if (s.length() == 1 || s.equals(new StringBuilder(s).reverse().toString()))
			return -1;

		for (int i = 0; i < s.length(); i++) {
			StringBuilder forward = new StringBuilder(s).deleteCharAt(i);
			StringBuilder reverse = new StringBuilder(forward.toString()).reverse();
			if (forward.toString().equals(reverse.toString()))
				return i;
		}
		return -1;
	}
}
