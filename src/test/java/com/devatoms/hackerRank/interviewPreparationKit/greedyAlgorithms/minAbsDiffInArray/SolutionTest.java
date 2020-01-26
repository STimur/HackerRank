package com.devatoms.hackerRank.interviewPreparationKit.greedyAlgorithms.minAbsDiffInArray;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		int[] arr = {-59, -36, -13, 1, -53, -92, -2, -96, -54, 75};
		assertThat(minimumAbsoluteDifference(arr), is(1));
	}

	static int minimumAbsoluteDifference(int[] arr) {
		Arrays.sort(arr);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length - 1; i++) {
			int minCandidate = Math.abs(arr[i] - arr[i + 1]);
			if (minCandidate < min)
				min = minCandidate;
		}
		return min;
	}
}
