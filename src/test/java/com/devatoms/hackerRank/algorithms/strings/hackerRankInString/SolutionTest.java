package com.devatoms.hackerRank.algorithms.strings.hackerRankInString;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	@Test
	@Parameters({"null, NO", "hacker, NO",
			"hackerrank, YES", "hiackerrank, YES", "hackerrankz, YES"})
	public void solution(String s, String result) {
		assertThat(hackerrankInString(s)).isEqualTo(result);
	}

	static String hackerrankInString(String s) {
		if (s == null)
			return "NO";

		String subsequenceToFind = "hackerrank";
		int i = 0;

		for (char c : s.toCharArray()) {
			if (c == subsequenceToFind.charAt(i))
				i++;
			if (i == subsequenceToFind.length())
				return "YES";
		}
		return "NO";
	}
}
