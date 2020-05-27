package com.devatoms.hackerRank.algorithms.strings.gemstones;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(gemstones(new String[]{"a", "a"})).isEqualTo(1);
		assertThat(gemstones(new String[]{"a", "b"})).isEqualTo(0);
		assertThat(gemstones(new String[]{"aa", "b"})).isEqualTo(0);
	}

	static int gemstones(String[] arr) {
		final int n = arr.length;
		boolean[] charFound = new boolean[26];
		Map<Character, Integer> dict = new HashMap<>();

		for (String str : arr) {
			for (char c : str.toCharArray()) {
				if (!charFound[c - 97]) {
					dict.compute(c, (k, v) -> v == null ? 1 : v + 1);
					charFound[c - 97] = true;
				}
			}
			charFound = new boolean[26];
		}

		int count = 0;
		for (Map.Entry<Character, Integer> el : dict.entrySet())
			if (el.getValue() == n)
				count++;

		return count;
	}
}
