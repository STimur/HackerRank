package com.devatoms.hackerRank.algorithms.warmup.staircase;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
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

	public Object testData() {
		return new Object[]{
				new Object[]{1, "#\n"},
				new Object[]{2, " #\n##\n"},
				new Object[]{3, "  #\n ##\n###\n"},
		};
	}

	@Test
	@Parameters(method = "testData")
	public void solution(int n, String result) {
		staircase(n);
		assertThat(outContent.toString()).isEqualTo(result);
	}

	static void staircase(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++)
				System.out.print(" ");
			for (int k = 1; k <= i; k++)
				System.out.print("#");
			System.out.println();
		}
	}
}
