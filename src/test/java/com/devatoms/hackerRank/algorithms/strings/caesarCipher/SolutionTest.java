package com.devatoms.hackerRank.algorithms.strings.caesarCipher;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(caesarCipher("a", 0), is("a"));
	}

	static String caesarCipher(String s, int k) {
		return "a";
	}
}
