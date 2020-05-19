package com.devatoms.hackerRank.algorithms.strings.anagram;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(anagram("a"), is(-1));
		assertThat(anagram("aa"), is(0));
		assertThat(anagram("ab"), is(1));
		assertThat(anagram("aaabaa"), is(1));
	}

	int anagram(String s) {
		if (s.length() % 2 != 0)
			return -1;

		String s1 = s.substring(0, s.length() / 2);
		String s2 = s.substring(s.length() / 2);

		Map<Character, Integer> dict1 = new HashMap<>();
		Map<Character, Integer> dict2 = new HashMap<>();
		for (char c : s1.toCharArray())
			dict1.compute(c, (k, v) -> v == null ? 1 : v + 1);
		for (char c : s2.toCharArray())
			dict2.compute(c, (k, v) -> v == null ? 1 : v + 1);

		for (char c : dict2.keySet())
			dict1.compute(c, (k, v) -> v == null ? null : v - dict2.get(c));

		return dict1.values().stream().filter(a -> a > 0).reduce(0, Integer::sum);
	}
}
