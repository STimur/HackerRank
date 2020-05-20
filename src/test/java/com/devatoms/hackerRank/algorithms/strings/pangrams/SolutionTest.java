package com.devatoms.hackerRank.algorithms.strings.pangrams;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(pangrams("We promptly judged antique ivory buckles for the next prize"), is("pangram"));
		assertThat(pangrams("We promptly judged antique ivory buckles for the prize"), is("not pangram"));
	}

	@Test
	public void char_type() {
		assertThat('a' + 0, is(97));
		assertThat('z' + 0, is(122));
		assertThat('z' - 'a', is(25));
	}

	static String pangrams(String s) {
		int[] dict = new int[26];

		for (char c : s.toLowerCase().toCharArray())
			if (c != ' ')
				dict[c - 97]++;

		for (int i = 0; i < dict.length; i++)
			if (dict[i] == 0)
				return "not pangram";

		return "pangram";
	}
}
