package com.devatoms.hackerRank.algorithms.strings.strongPassword;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	String special_characters = "!@#$%^&*()-+";

	@Test
	public void solution() {
		assertThat(minimumNumber(1, "a"), is(5));
		assertThat(minimumNumber(2, "ab"), is(4));
		assertThat(minimumNumber(3, "abc"), is(3));
		assertThat(minimumNumber(4, "abcd"), is(3));
	}

	static int minimumNumber(int n, String password) {
		String special_characters = "!@#$%^&*()-+";
		int lengthToAdd = 6 - password.length();

		boolean hasOneUpperCaseLetter = false;
		boolean hasOneLowerCaseLetter = false;
		boolean hasOneDigit = false;
		boolean hasOneSpecialCharacter = false;

		int charsToAdd = 4;

		for (Character c : password.toCharArray()) {
			if (!hasOneUpperCaseLetter && Character.isUpperCase(c)) {
				hasOneUpperCaseLetter = true;
				charsToAdd--;
			}
			if (!hasOneLowerCaseLetter && Character.isLowerCase(c)) {
				hasOneLowerCaseLetter = true;
				charsToAdd--;
			}
			if (!hasOneDigit && Character.isDigit(c)) {
				hasOneDigit = true;
				charsToAdd--;
			}
			if (!hasOneSpecialCharacter && special_characters.contains(c.toString())) {
				hasOneSpecialCharacter = true;
				charsToAdd--;
			}
		}

		if (charsToAdd < 0)
			charsToAdd = 0;
		if (lengthToAdd < 0)
			lengthToAdd = 0;

		return Math.max(charsToAdd, lengthToAdd);
	}
}
