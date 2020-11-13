package com.devatoms.hackerRank.algorithms.implementation.billDivision;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

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
		bonAppetit(Arrays.asList(1, 2), 0, 0);
		assertThat(outContent.toString()).isEqualTo("-1\n");
		outContent.reset();

		bonAppetit(Arrays.asList(1, 2), 0, 1);
		assertThat(outContent.toString()).isEqualTo("Bon Appetit\n");
		outContent.reset();

		bonAppetit(Arrays.asList(1, 2), 0, 2);
		assertThat(outContent.toString()).isEqualTo("1\n");
	}

	static void bonAppetit(List<Integer> bill, int k, int b) {
		int share = 0;
		for (int i = 0; i < bill.size(); i++) {
			if (i == k)
				continue;
			share += bill.get(i);
		}
		share /= 2;

		if (b == share)
			System.out.println("Bon Appetit");
		else
			System.out.println(b - share);
	}
}
