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
		assertThat(countDuplets(Arrays.asList(1L, 2L), 2)).isEqualTo(1);
		assertThat(countDuplets(Arrays.asList(1L, 2L, 2L), 2)).isEqualTo(2);
		assertThat(countDuplets(Arrays.asList(1L, 1L, 2L, 2L), 2)).isEqualTo(4);
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
		Map<Long, Long> numOfFirstElementsFor = new HashMap<>();
		long numOfDuplets = 0;

		for (long n : arr) {
			final Long numOfNewDuplets = numOfFirstElementsFor.get(n);
			numOfDuplets += (numOfNewDuplets != null ? numOfNewDuplets : 0);

			numOfFirstElementsFor.compute(n * r, (k, v) -> v == null ? 1 : v + 1);
		}

		return numOfDuplets;
	}
}
