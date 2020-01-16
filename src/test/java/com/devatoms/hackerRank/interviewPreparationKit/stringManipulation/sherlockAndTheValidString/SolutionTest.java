package com.devatoms.hackerRank.interviewPreparationKit.stringManipulation.sherlockAndTheValidString;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void simplest_case() throws IOException {
		assertThat(isValid("a"), is("YES"));
		assertThat(isValid("abbb"), is("YES"));
		assertThat(isValid("abbcc"), is("YES"));
		assertThat(isValid("abbccd"), is("NO"));
		assertThat(isValid("aaaabbcc"), is("NO"));
		assertThat(isValid("aabbccc"), is("YES"));

		String x = new String(Files.readAllBytes(Paths.get("src/test/resources/test.txt")));
		assertThat(isValid(x), is("YES"));
	}

	static String isValid(String s) {
		Map<Character, Integer> charDict = new HashMap<>();

		for (char c : s.toCharArray()) {
			if (!charDict.containsKey(c))
				charDict.put(c, 1);
			else
				charDict.put(c, charDict.get(c) + 1);
		}

		Integer[] charFreq = charDict.values().toArray(new Integer[charDict.values().size()]);
		if (charFreq.length == 1)
			return "YES";

		Map<Integer, Integer> freqDict = new HashMap<>();
		for (int i : charFreq) {
			if (!freqDict.containsKey(i))
				freqDict.put(i, 1);
			else
				freqDict.put(i, freqDict.get(i) + 1);
		}

		if (freqDict.keySet().size() == 1)
			return "YES";

		if (freqDict.values().size() > 2)
			return "NO";

		if (freqDict.get(1) != null && freqDict.get(1) == 1)
			return "YES";

		Integer[] freqFreq = freqDict.values().toArray(new Integer[freqDict.values().size()]);
		Integer[] freqKeys = freqDict.keySet().toArray(new Integer[freqDict.keySet().size()]);
		if ((freqFreq[0] > 1 && freqFreq[1] > 1) || Math.abs(freqKeys[0] - freqKeys[1]) != 1)
			return "NO";

		return "YES";
	}
}
