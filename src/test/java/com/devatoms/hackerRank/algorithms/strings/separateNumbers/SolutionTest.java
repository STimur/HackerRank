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
		assertThat(outContent.toString()).isEqualTo("NO");
		outContent.reset();
		separateNumbers("12");
		assertThat(outContent.toString()).isEqualTo("YES");
	}

	static void separateNumbers(String s) {
		if (s.length() == 1) {
			System.out.print("NO");
			return;
		}

		if (s.charAt(1) - s.charAt(0) == 1) {
			System.out.print("YES");
			return;
		}
		System.out.print("NO");
	}
}
