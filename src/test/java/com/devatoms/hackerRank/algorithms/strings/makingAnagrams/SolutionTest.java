package com.devatoms.hackerRank.algorithms.strings.makingAnagrams;

import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(makingAnagrams("a", "a"), is(0));
		assertThat(makingAnagrams("a", "aa"), is(1));
		assertThat(makingAnagrams("a", "bb"), is(3));
	}

	static int makingAnagrams(String s1, String s2) {
		HashMap<Character, Integer> dict = new HashMap<>();

		for (char c : s1.toCharArray()) {
			if (dict.containsKey(c))
				dict.put(c, dict.get(c) + 1);
			else
				dict.put(c, 1);
		}

		for (char c : s2.toCharArray()) {
			if (dict.containsKey(c))
				dict.put(c, dict.get(c) - 1);
			else
				dict.put(c, -1);
		}

		return dict.values().stream().reduce(0, (a, b) -> a + Math.abs(b));
	}
}
