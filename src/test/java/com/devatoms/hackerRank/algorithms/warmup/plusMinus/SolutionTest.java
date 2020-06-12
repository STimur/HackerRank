package com.devatoms.hackerRank.algorithms.warmup.plusMinus;

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
				new Object[]{new int[]{0}, new String[]{"0.000000", "0.000000", "1.000000"}},
				new Object[]{new int[]{1}, new String[]{"1.000000", "0.000000", "0.000000"}},
				new Object[]{new int[]{-1}, new String[]{"0.000000", "1.000000", "0.000000"}},
		};
	}

	@Test
	@Parameters(method = "testData")
	public void solution(int arr[], String[] expectedResults) {
		plusMinus(arr);
		String[] results = outContent.toString().split("\n");
		assertThat(results[0]).isEqualTo(expectedResults[0]);
		assertThat(results[1]).isEqualTo(expectedResults[1]);
		assertThat(results[2]).isEqualTo(expectedResults[2]);
	}

	static void plusMinus(int[] arr) {
		int positiveCount = 0;
		int negativeCount = 0;
		int zerosCount = 0;
		int n = arr.length;

		for (int i : arr)
			if (i > 0)
				positiveCount++;
			else if (i == 0)
				zerosCount++;
			else
				negativeCount++;

		System.out.printf("%.6f\n", 1f * positiveCount / n);
		System.out.printf("%.6f\n", 1f * negativeCount / n);
		System.out.printf("%.6f", 1f * zerosCount / n);
	}
}
