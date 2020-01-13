package com.devatoms.hackerRank.interviewPreparationKit.stringManipulation.makingAnagrams;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void simplest_case() {
		assertThat(makeAnagram("a", "a"), is(0));
	}

	@Test
	public void no_same_characters() {
		assertThat(makeAnagram("a", "b"), is(2));
	}

	static int makeAnagram(String a, String b) {
		Map<Character, Integer> aDict = new HashMap<>();

		for (char c : a.toCharArray())
			if (aDict.containsKey(c))
				aDict.put(c, aDict.get(c) + 1);
			else
				aDict.put(c, 1);

		for (char c : b.toCharArray())
			if (aDict.containsKey(c))
				aDict.put(c, aDict.get(c) - 1);
			else
				aDict.put(c, -1);

		int res = 0;
		for (int i : aDict.values())
			res += Math.abs(i);

		return res;
	}
}
