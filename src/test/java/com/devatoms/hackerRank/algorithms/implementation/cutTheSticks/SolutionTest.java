package com.devatoms.hackerRank.algorithms.implementation.cutTheSticks;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(cutTheSticks(new int[]{1})).isEqualTo(new int[]{1});
		assertThat(cutTheSticks(new int[]{1, 1})).isEqualTo(new int[]{2});
		assertThat(cutTheSticks(new int[]{1, 2})).isEqualTo(new int[]{2, 1});
		assertThat(cutTheSticks(new int[]{1, 2, 3})).isEqualTo(new int[]{3, 2, 1});
		assertThat(cutTheSticks(new int[]{3, 1, 2})).isEqualTo(new int[]{3, 2, 1});
		assertThat(cutTheSticks(new int[]{5, 4, 4, 2, 2, 8})).isEqualTo(new int[]{6, 4, 2, 1});
		assertThat(cutTheSticks(new int[]{1, 2, 3, 4, 3, 3, 2, 1})).isEqualTo(new int[]{8, 6, 4, 1});
	}

	static int[] cutTheSticks(int[] arr) {
		Queue<Integer> res = new LinkedList<>();
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				int shortestLength = arr[i];
				int numOfDiscarded = 0;
				for (int j = i; j < arr.length; j++) {
					arr[j] -= shortestLength;
					numOfDiscarded++;
				}
				res.add(numOfDiscarded);
			}
		}

		return res.stream().mapToInt(i -> i).toArray();
	}
}
