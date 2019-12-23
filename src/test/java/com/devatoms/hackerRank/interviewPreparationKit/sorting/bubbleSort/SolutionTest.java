package com.devatoms.hackerRank.interviewPreparationKit.sorting.bubbleSort;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	@Before
	public void setUpStreams() {
		System.setOut(new PrintStream(outContent));
		System.setErr(new PrintStream(errContent));
	}

	@Test
	public void swap() {
		int[] array = {1, 2};
		swap(array, 0, 1);
		assertThat(array[0], is(2));
		assertThat(array[1], is(1));
	}

	@Test
	public void countSwaps() {
		countSwaps(new int[]{3, 2, 1});

		String[] lines = outContent.toString().split("\n");
		assertThat(lines[0], is("Array is sorted in 3 swaps."));
		assertThat(lines[1], is("First Element: 1"));
		assertThat(lines[2], is("Last Element: 3"));
	}

	@After
	public void restoreStreams() {
		System.setOut(originalOut);
		System.setErr(originalErr);
	}

	static void countSwaps(int[] a) {
		int n = a.length;
		int swaps = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
					swaps++;
				}
			}
		}

		System.out.printf("Array is sorted in %d swaps.\n", swaps);
		System.out.printf("First Element: %d\n", a[0]);
		System.out.printf("Last Element: %d\n", a[n - 1]);
	}

  private static void swap(int[] a, int i, int j) {
    int t = a[i];
    a[i] = a[j];
    a[j] = t;
  }
}
