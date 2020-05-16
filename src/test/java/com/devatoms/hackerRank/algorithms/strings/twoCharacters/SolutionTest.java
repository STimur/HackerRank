package com.devatoms.hackerRank.algorithms.strings.twoCharacters;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(alternate("a"), is(0));
		assertThat(alternate("a"), is(0));
		assertThat(alternate("beabeefeab"), is(5));
	}

	static int alternate(String s) {
		Set<Character> charSet = new HashSet<>();

		for (int i = 0; i < s.length(); i++)
			charSet.add(s.charAt(i));

		Character[] charArr = charSet.toArray(new Character[charSet.size()]);
		int max = 0;

		for (int j = 0; j < charArr.length - 1; j++) {
			for (int k = j + 1; k < charArr.length; k++) {
				String pattern = "([^" + charArr[j] + charArr[k] + "])";
				String trimmedStr = s.replaceAll(pattern, "");
				if (isTwoCharacter(trimmedStr) && trimmedStr.length() > max) {
					max = trimmedStr.length();
				}
			}
		}
		return max;
	}

	private static boolean isTwoCharacter(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				return false;
			}
		}
		return true;
	}
}
