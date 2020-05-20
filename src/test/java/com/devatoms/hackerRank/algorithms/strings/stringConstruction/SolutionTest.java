package com.devatoms.hackerRank.algorithms.strings.stringConstruction;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(stringConstruction("a"), is(1));
		assertThat(stringConstruction("ab"), is(2));
		assertThat(stringConstruction("aba"), is(2));
	}

	static int stringConstruction(String s) {
		Map<Character, Integer> dict = new HashMap<>();

		int cost = 0;
		for (char c : s.toCharArray())
			if (!dict.containsKey(c)) {
				cost++;
				dict.put(c, 1);
			}

		return cost;
	}
}
