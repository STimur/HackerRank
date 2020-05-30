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
	public void ancillary() {
		assertThat(isSeparatable("1", 1)).isEqualTo(true);
		assertThat(isSeparatable("13", 1)).isEqualTo(false);
		assertThat(isSeparatable("1011", 2)).isEqualTo(true);
		assertThat(isSeparatable("910", 2)).isEqualTo(true);
	}

	@Test
	public void solution() {
		separateNumbers("1");
		assertThat(outContent.toString()).isEqualTo("NO");
		outContent.reset();
		separateNumbers("12");
		assertThat(outContent.toString()).isEqualTo("YES");
		outContent.reset();
		separateNumbers("124");
		assertThat(outContent.toString()).isEqualTo("NO");
		outContent.reset();
		separateNumbers("1011");
		assertThat(outContent.toString()).isEqualTo("YES");
	}

	static void separateNumbers(String s) {
		if (s.length() == 1) {
			System.out.print("NO");
			return;
		}

		int numOfCharsInInt = 1;
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i + 1) - s.charAt(i) != 1) {
				System.out.print("NO");
				return;
			}
		}
		System.out.print("YES");
	}

	static boolean isSeparatable(String s, int numOfCharsInInt) {
		for (int i = 0; i < s.length() - numOfCharsInInt; i += numOfCharsInInt) {
			final Integer Int = Integer.valueOf(s.substring(i, i + numOfCharsInInt));
			final Integer nextInt = Integer.valueOf(s.substring(i + numOfCharsInInt, i + 2 * numOfCharsInInt));
			if (nextInt - Int != 1) {
				return false;
			}
		}
		return true;
	}
}
