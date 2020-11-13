package com.devatoms.hackerRank.algorithms.implementation.migratoryBirds;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(migratoryBirds(Arrays.asList(1, 1, 1, 1, 1))).isEqualTo(1);
		assertThat(migratoryBirds(Arrays.asList(2, 2, 2, 1, 1))).isEqualTo(2);
		assertThat(migratoryBirds(Arrays.asList(1, 4, 4, 4, 5, 3))).isEqualTo(4);
		assertThat(migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4))).isEqualTo(3);
	}

	static int migratoryBirds(List<Integer> arr) {
		int[] counts = new int[5];
		for (int i = 0; i < arr.size(); i++)
			counts[arr.get(i) - 1]++;

		int max = 0, indexOfMax = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] > max) {
				max = counts[i];
				indexOfMax = i;
			}
		}
		return indexOfMax + 1;
	}
}
