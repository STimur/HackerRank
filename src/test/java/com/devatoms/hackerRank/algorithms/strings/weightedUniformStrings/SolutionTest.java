package com.devatoms.hackerRank.algorithms.strings.weightedUniformStrings;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void ancillary() {
		assertThat('a' - 96).isEqualTo(1);
		assertThat('l' - 96).isEqualTo(12);
		assertThat('z' - 96).isEqualTo(26);
	}

	@Test
	public void solution() {
		assertThat(weightedUniformStrings("a", new int[]{1})).isEqualTo(new String[]{"Yes"});
		assertThat(weightedUniformStrings("a", new int[]{1, 2})).isEqualTo(new String[]{"Yes", "No"});
		assertThat(weightedUniformStrings("aa", new int[]{1, 2})).isEqualTo(new String[]{"Yes", "Yes"});
		assertThat(weightedUniformStrings("l", new int[]{1, 12})).isEqualTo(new String[]{"No", "Yes"});
	}

	static String[] weightedUniformStrings(String s, int[] queries) {
		Map<Integer, Integer> dict = new HashMap<>();
		final int BEFORE_LOWER_A_CHAR_CODE = 96;
		for (char c : s.toCharArray()) {
			final int key = c - BEFORE_LOWER_A_CHAR_CODE;
			dict.compute(key, (k, v) -> v == null ? k : v + k);
		}

		String[] res = new String[queries.length];
		int i = 0;
		for (int query : queries) {
			if (dict.entrySet().stream().anyMatch(e -> query <= e.getValue() && (e.getValue() - query) % e.getKey() == 0))
				res[i] = "Yes";
			else
				res[i] = "No";
			i++;
		}

		return res;
	}
}
