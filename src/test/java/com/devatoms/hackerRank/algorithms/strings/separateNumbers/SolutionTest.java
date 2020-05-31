package com.devatoms.hackerRank.algorithms.strings.separateNumbers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
	}

	@Test
	public void solution() {
		separateNumbers("1");
		assertThat(outContent.toString()).isEqualTo("NO\n");
		outContent.reset();
		separateNumbers("12");
		assertThat(outContent.toString()).isEqualTo("YES 1\n");
		outContent.reset();
		separateNumbers("124");
		assertThat(outContent.toString()).isEqualTo("NO\n");
		outContent.reset();
		separateNumbers("1011");
		assertThat(outContent.toString()).isEqualTo("YES 10\n");
		outContent.reset();
		separateNumbers("91011");
		assertThat(outContent.toString()).isEqualTo("YES 9\n");
	}

	static void separateNumbers(String s) {

		for (int numOfCharsInInt = 1; numOfCharsInInt <= s.length() / 2; numOfCharsInInt++) {
			final String first = s.substring(0, numOfCharsInInt);

			for (int i = 0; i < s.length() - numOfCharsInInt; ) {
				final Integer cur = Integer.valueOf(s.substring(i, i + numOfCharsInInt));
				final String next = String.valueOf(cur + 1);

				if (!s.substring(i + numOfCharsInInt, i + numOfCharsInInt + next.length()).equals(next)) {
					break;
				}

				if (i == s.length() - numOfCharsInInt - next.length()) {
					System.out.println("YES " + first);
					return;
				}

				i += numOfCharsInInt;
				numOfCharsInInt = next.length();
			}
		}
		System.out.println("NO");
	}
}
