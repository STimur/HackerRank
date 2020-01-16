package com.devatoms.hackerRank.interviewPreparationKit.stringManipulation.sherlockAndTheValidString;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void simplest_case() {
		assertThat(isValid("a"), is("YES"));
		assertThat(isValid("abbb"), is("YES"));
		assertThat(isValid("abbcc"), is("YES"));
		assertThat(isValid("abbccd"), is("NO"));
	}

	static String isValid(String s) {
		Map<Character, Integer> dict = new HashMap<>();

		for (char c : s.toCharArray()) {
			if (!dict.containsKey(c))
				dict.put(c, 1);
			else
				dict.put(c, dict.get(c) + 1);
		}

		Integer[] frequencies = dict.values().toArray(new Integer[dict.values().size()]);
		if (frequencies.length == 1)
			return "YES";

		Map<Integer, Integer> freqDict = new HashMap<>();
		for (int i : frequencies) {
			if (!freqDict.containsKey(i))
				freqDict.put(i, 1);
			else
				freqDict.put(i, freqDict.get(i) + 1);
		}

		if (freqDict.values().size() > 2)
			return "NO";

		Integer[] freqFreq = freqDict.values().toArray(new Integer[freqDict.values().size()]);
		if ((freqFreq[0] > 1 && freqFreq[1] > 1))
			return "NO";

		return "YES";
	}
}
