package com.devatoms.hackerRank.algorithms.strings.superReducedString;

import org.junit.Test;

import java.util.Queue;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(superReducedString("a"), is("a"));
		assertThat(superReducedString("aa"), is("Empty String"));
		assertThat(superReducedString("aab"), is("b"));
		assertThat(superReducedString("baab"), is("Empty String"));
	}

	static String superReducedString(String s) {
		for (int i = 0; i < s.length() - 1; ) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				s = s.substring(0, i) + s.substring(i + 2);
				i = 0;
				continue;
			}
			i++;
		}

		if (s.length() == 0)
			return "Empty String";
		return s;
	}
}
