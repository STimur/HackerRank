package com.devatoms.hackerRank.algorithms.strings.marsExploration;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(marsExploration("SOS"), is(0));
		assertThat(marsExploration("TOS"), is(1));
	}

	static int marsExploration(String s) {
		int lettersChanged = 0;
		for (int i = 0; i < s.length(); i += 3) {
			if (s.charAt(i) != 'S')
				lettersChanged++;
			if (s.charAt(i + 1) != 'O')
				lettersChanged++;
			if (s.charAt(i + 2) != 'S')
				lettersChanged++;
		}
		return lettersChanged;
	}
}
