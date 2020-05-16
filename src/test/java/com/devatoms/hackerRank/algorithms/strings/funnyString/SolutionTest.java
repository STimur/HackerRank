package com.devatoms.hackerRank.algorithms.strings.funnyString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(funnyString("aa"), is("Funny"));
		assertThat(funnyString("aab"), is("Not Funny"));
		assertThat(funnyString("aaa"), is("Funny"));
		assertThat(funnyString("acxz"), is("Funny"));
	}

	static String funnyString(String s) {
		int[] diffs = new int[s.length() - 1];
		String r = new StringBuilder(s).reverse().toString();
		int[] diffsR = new int[r.length() - 1];

		for (int i = 0; i < s.length() - 1; i++) {
			diffs[i] = Math.abs(s.charAt(i) - s.charAt(i + 1));
			diffsR[i] = Math.abs(r.charAt(i) - r.charAt(i + 1));
		}

		for (int i = 0; i < s.length() - 1; i++)
			if (diffs[i] != diffsR[i])
				return "Not Funny";

		return "Funny";
	}
}
