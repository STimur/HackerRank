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
		separateNumbers("a");
		assertThat(outContent.toString()).isEqualTo("NO");
	}

	static void separateNumbers(String s) {
		System.out.print("NO");
	}
}
