package com.devatoms.hackerRank.algorithms.strings.caesarCipher;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(caesarCipher("a", 0), is("a"));
		assertThat(caesarCipher("a", 1), is("b"));
		assertThat(caesarCipher("z", 1), is("a"));
		assertThat(caesarCipher("a-z", 1), is("b-a"));
		assertThat(caesarCipher("Z", 1), is("A"));
		assertThat(caesarCipher("A", 1), is("B"));
		assertThat(caesarCipher("A-Z", 1), is("B-A"));
	}

	@Test
	public void explore_charcodes() {
		assertThat('a' + 0, is(97));
		assertThat('z' + 0, is(122));
		assertThat('A' + 0, is(65));
		assertThat('Z' + 0, is(90));
	}

	static String caesarCipher(String s, int k) {
		final int A_LOWERCASE_CHARCODE = 'a';
		final int Z_LOWERCASE_CHARCODE = 'z';
		final int A_UPPERCASE_CHARCODE = 'A';
		final int Z_UPPERCASE_CHARCODE = 'Z';
		StringBuilder cipheredString = new StringBuilder();
		k = k % 26;

		for (char c : s.toCharArray()) {
			if (Character.isUpperCase(c)) {
				int cipheredCharcode = c + k;
				if (cipheredCharcode > Z_UPPERCASE_CHARCODE)
					cipheredCharcode = A_UPPERCASE_CHARCODE + (cipheredCharcode - Z_UPPERCASE_CHARCODE - 1);
				cipheredString.append((char) cipheredCharcode);
			} else if (Character.isLowerCase(c)) {
				int cipheredCharcode = c + k;
				if (cipheredCharcode > Z_LOWERCASE_CHARCODE)
					cipheredCharcode = A_LOWERCASE_CHARCODE + (cipheredCharcode - Z_LOWERCASE_CHARCODE - 1);
				cipheredString.append((char) cipheredCharcode);
			} else
				cipheredString.append(c);
		}

		return cipheredString.toString();
	}
}
