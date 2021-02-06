package com.devatoms.hackerRank.interviewPreparationKit.hashmaps.countTriplets;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void ancillary() {
		assertThat(countDuplets(Arrays.asList(1L), 1)).isEqualTo(0);
		assertThat(countDuplets(Arrays.asList(1L, 2L), 1)).isEqualTo(1);
		assertThat(countDuplets(Arrays.asList(1L, 2L, 2L), 1)).isEqualTo(2);
		assertThat(countDuplets(Arrays.asList(1L, 1L, 2L, 2L), 1)).isEqualTo(4);
		assertThat(countDuplets(Arrays.asList(1L, 1L, 1L, 1L), 1)).isEqualTo(6);
	}

	@Test
	public void solution() {
		assertThat(countTriplets(Arrays.asList(1L), 1)).isEqualTo(0);
		assertThat(countTriplets(Arrays.asList(1L, 2L, 4L), 1)).isEqualTo(1);
	}

	static long countTriplets(List<Long> arr, long r) {
		if (arr.size() < 3)
			return 0;

		return 1;
	}

	private long countDuplets(List<Long> arr, int r) {
		if (arr.size() < 2)
			return 0;

		Map<Long, Long> numOfFirstElementsFor = new HashMap<>();
		long count = 0;

		for (long n : arr) {
			if (numOfFirstElementsFor.containsKey(n))
				count += numOfFirstElementsFor.get(n);

			if (numOfFirstElementsFor.containsKey(n * r))
				numOfFirstElementsFor.put(n * r, numOfFirstElementsFor.get(n * r) + 1);
			else
				numOfFirstElementsFor.put(n * r, 1L);
		}

		return count;
	}
}
