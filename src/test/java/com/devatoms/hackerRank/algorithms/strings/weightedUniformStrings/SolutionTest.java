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
		assertThat(weightedUniformStrings("aca", new int[]{1, 2})).isEqualTo(new String[]{"Yes", "No"});
		assertThat(weightedUniformStrings("de", new int[]{5})).isEqualTo(new String[]{"Yes"});
	}

	static String[] weightedUniformStrings(String s, int[] queries) {
		Map<Integer, Integer> dictMax = new HashMap<>();
		Map<Integer, Integer> dict = new HashMap<>();
		final int BEFORE_LOWER_A_CHAR_CODE = 96;
		final int firstCharKey = s.charAt(0) - BEFORE_LOWER_A_CHAR_CODE;
		dict.put(firstCharKey, firstCharKey);
		dictMax.put(firstCharKey, firstCharKey);

		for (int i = 1; i < s.length(); i++) {
			final int prevCharKey = s.charAt(i - 1) - BEFORE_LOWER_A_CHAR_CODE;
			final int currCharKey = s.charAt(i) - BEFORE_LOWER_A_CHAR_CODE;
			if (prevCharKey == currCharKey)
				dict.compute(prevCharKey, (k, v) -> v + k);
			else {
				dict.compute(currCharKey, (k, v) -> currCharKey);
				if (dictMax.getOrDefault(prevCharKey, 0) < dict.get(prevCharKey))
					dictMax.put(prevCharKey, dict.get(prevCharKey));
			}
		}
		final int lastCharKey = s.charAt(s.length() - 1) - BEFORE_LOWER_A_CHAR_CODE;
		if (dictMax.getOrDefault(lastCharKey, 0) < dict.get(lastCharKey))
			dictMax.put(lastCharKey, dict.get(lastCharKey));

		String[] res = new String[queries.length];
		int i = 0;
		for (int query : queries) {
			if (dictMax.entrySet().stream().anyMatch(e -> query <= e.getValue() && (e.getValue() - query) % e.getKey() == 0))
				res[i] = "Yes";
			else
				res[i] = "No";
			i++;
		}

		return res;
	}
}
