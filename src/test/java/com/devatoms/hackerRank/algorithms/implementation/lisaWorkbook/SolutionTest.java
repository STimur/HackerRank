package com.devatoms.hackerRank.algorithms.implementation.lisaWorkbook;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(workbook(1, 1, new int[]{1})).isEqualTo(1);
		assertThat(workbook(1, 1, new int[]{2})).isEqualTo(2);
		assertThat(workbook(2, 2, new int[]{1, 2})).isEqualTo(2);
		assertThat(workbook(5, 3, new int[]{4, 2, 6, 1, 10})).isEqualTo(4);
	}

	static int workbook(int n, int k, int[] arr) {
		int numOfSpecialProblems = 0;
		int currentPageNumber = 1;
		int currentNumberOfProblemOnPages = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= arr[i]; j++) {
				if (j == currentPageNumber)
					numOfSpecialProblems++;
				currentNumberOfProblemOnPages++;
				if (currentNumberOfProblemOnPages == k) {
					currentPageNumber++;
					currentNumberOfProblemOnPages = 0;
				}
			}
			if (currentNumberOfProblemOnPages != 0) {
				currentNumberOfProblemOnPages = 0;
				currentPageNumber++;
			}
		}

		return numOfSpecialProblems;
	}
}
