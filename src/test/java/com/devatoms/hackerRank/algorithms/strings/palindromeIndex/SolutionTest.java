package com.devatoms.hackerRank.algorithms.strings.palindromeIndex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(palindromeIndex("a"), is(-1));
		assertThat(palindromeIndex("aa"), is(-1));
		assertThat(palindromeIndex("ab"), is(0));
		assertThat(palindromeIndex("abb"), is(0));
		assertThat(palindromeIndex("abc"), is(-1));
		assertThat(palindromeIndex("abac"), is(3));
	}

	static int palindromeIndex(String s) {
		int l = 0;
		int r = s.length() - 1;

		while (l < r && s.charAt(l) == s.charAt(r)) {
			l++;
			r--;
		}
		if (l >= r)
			return -1;

		int i = l, lmem = l, rmem = r;
		l = l + 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {
			l++;
			r--;
		}
		if (l >= r)
			return i;

		i = rmem;
		l = lmem;
		r = rmem - 1;
		while (l < r && s.charAt(l) == s.charAt(r)) {
			l++;
			r--;
		}
		if (l >= r)
			return i;

		return -1;
	}
}
