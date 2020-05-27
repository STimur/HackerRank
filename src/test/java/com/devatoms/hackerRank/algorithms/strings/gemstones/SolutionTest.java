package com.devatoms.hackerRank.algorithms.strings.gemstones;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	public Object testData() {
		return new Object[]{
				new Object[]{new String[]{"a", "a"}, 1},
				new Object[]{new String[]{"a", "b"}, 0},
				new Object[]{new String[]{"aa", "b"}, 0},
		};
	}

	@Test
	@Parameters(method = "testData")
	public void solution(String[] arr, int res) {
		assertThat(gemstones(arr)).isEqualTo(res);
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
