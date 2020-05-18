package com.devatoms.hackerRank.algorithms.strings.gameOfThronesOne;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() throws IOException {
		assertThat(gameOfThrones("a"), is("YES"));
		assertThat(gameOfThrones("ab"), is("NO"));
		assertThat(gameOfThrones("aba"), is("YES"));
		assertThat(gameOfThrones("aabb"), is("YES"));
	}

	static String gameOfThrones(String s) {
		Map<Character, Integer> dict = new HashMap<>();

		for (char c : s.toCharArray()) {
			if (dict.containsKey(c))
				dict.put(c, dict.get(c) + 1);
			else
				dict.put(c, 1);
		}

		int numberOfOddChars = 0;
		for (int i : dict.values())
			if (i % 2 == 1)
				numberOfOddChars++;

		if (numberOfOddChars > 1)
			return "NO";
		return "YES";
	}
}
