package com.devatoms.hackerRank.algorithms.strings.theLoveLetterMystery;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(theLoveLetterMystery("a"), is(0));
		assertThat(theLoveLetterMystery("ab"), is(1));
	}

	static int theLoveLetterMystery(String s) {
		int res = 0;

		for (int l = 0, r = s.length() - 1; l < r; l++, r--) {
			final char leftChar = s.charAt(l);
			final char rightChar = s.charAt(r);
			if (leftChar != rightChar) {
				int diff = 0;
				if (leftChar > rightChar)
					diff = leftChar - rightChar;
				else
					diff = rightChar - leftChar;
				res += diff;
			}
		}
		return res;
	}
}
