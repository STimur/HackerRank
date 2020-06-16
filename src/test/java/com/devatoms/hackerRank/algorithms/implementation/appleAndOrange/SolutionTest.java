package com.devatoms.hackerRank.algorithms.implementation.appleAndOrange;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

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
		countApplesAndOranges(2, 3, 1, 4, new int[]{0}, new int[]{0});
		assertThat(outContent.toString()).isEqualTo("0\n0");
		outContent.reset();

		countApplesAndOranges(2, 3, 1, 4, new int[]{1}, new int[]{0});
		assertThat(outContent.toString()).isEqualTo("1\n0");
		outContent.reset();

		countApplesAndOranges(2, 3, 1, 4, new int[]{1}, new int[]{-1});
		assertThat(outContent.toString()).isEqualTo("1\n1");
		outContent.reset();

		countApplesAndOranges(7, 11, 5, 15, new int[]{-2, 2, 1}, new int[]{5, -6});
		assertThat(outContent.toString()).isEqualTo("1\n1");
	}

	static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
		System.out.println(Arrays.stream(apples).filter(i -> s <= a + i && a + i <= t).count());
		System.out.print(Arrays.stream(oranges).filter(i -> s <= b + i && b + i <= t).count());
	}
}
