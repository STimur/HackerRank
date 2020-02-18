package com.devatoms.hackerRank.interviewPreparationKit.greedyAlgorithms.luckBalance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(luckBalance(0, new int[][]{{1, 0}}), is(1));
		assertThat(luckBalance(0, new int[][]{{1, 1}}), is(-1));
		assertThat(luckBalance(1, new int[][]{{1, 1}}), is(1));
		assertThat(luckBalance(0, new int[][]{{1, 0}, {1, 0}}), is(2));
		assertThat(luckBalance(0, new int[][]{{1, 0}, {1, 0}, {2, 0}}), is(4));
		assertThat(luckBalance(3, new int[][]{{5, 1}, {2, 1}, {1, 1}, {8, 1}, {10, 0}, {5, 0}}), is(29));
		assertThat(luckBalance(3, new int[][]{{5, 0}, {2, 0}, {1, 0}, {8, 0}, {10, 0}, {5, 0}}), is(31));
		assertThat(luckBalance(2, new int[][]{{5, 1}, {2, 0}, {1, 0}, {8, 0}, {10, 0}, {5, 0}}), is(31));
	}

	static int luckBalance(int k, int[][] contests) {
		int luckBalance = 0;
		List<Integer> importantContests = new ArrayList<>();
		List<Integer> unimportantContests = new ArrayList<>();

		for (int i = 0; i < contests.length; i++) {
			if (contests[i][1] == 1)
				importantContests.add(contests[i][0]);
			else
				unimportantContests.add(contests[i][0]);
		}
		Collections.sort(importantContests);

		if (importantContests.size() != 0) {
			int numOfImportantContestsThatShouldBeWon = importantContests.size() - k;
			if (numOfImportantContestsThatShouldBeWon < 0)
				numOfImportantContestsThatShouldBeWon = 0;

			for (int i = 0; i < numOfImportantContestsThatShouldBeWon; i++)
				luckBalance -= importantContests.get(i);

			for (int i = numOfImportantContestsThatShouldBeWon; i < importantContests.size(); i++)
				luckBalance += importantContests.get(i);
		}

		for (int i = 0; i < unimportantContests.size(); i++)
			luckBalance += unimportantContests.get(i);

		return luckBalance;
	}
}
