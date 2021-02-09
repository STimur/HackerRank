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
		assertThat(countDuplets(Arrays.asList(1L, 1L, 2L), 2)).isEqualTo(2);
		assertThat(countDuplets(Arrays.asList(1L, 1L, 2L, 2L), 2)).isEqualTo(4);
		assertThat(countDuplets(Arrays.asList(1L, 1L, 1L), 1)).isEqualTo(3);
	}

	@Test
	public void solution() {
		assertThat(countTriplets(Arrays.asList(1L), 1)).isEqualTo(0);
		assertThat(countTriplets(Arrays.asList(1L, 1L, 1L), 1)).isEqualTo(1);
		assertThat(countTriplets(Arrays.asList(1L, 2L, 4L), 2)).isEqualTo(1);
		assertThat(countTriplets(Arrays.asList(1L, 1L, 1L, 1L), 1)).isEqualTo(4);
		assertThat(countTriplets(Arrays.asList(1L, 1L, 1L, 1L, 1L), 1)).isEqualTo(10);
	}

	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> numOfFirstElementsFor = new HashMap<>();
		Map<Long, Long> numOfDupletsFor = new HashMap<>();
		long numOfTriplets = 0;

		for (long n : arr) {
			Long numOfNewTriplets = numOfDupletsFor.get(n);
			if (numOfNewTriplets != null)
				numOfTriplets += numOfNewTriplets;

			Long numOfNewDuplets = numOfFirstElementsFor.get(n);
			if (numOfNewDuplets != null)
				numOfDupletsFor.compute(n * r, (k, v) -> v == null ? numOfNewDuplets : v + numOfNewDuplets);

			numOfFirstElementsFor.compute(n * r, (k, v) -> v == null ? 1 : v + 1);
		}

		return numOfTriplets;
	}

	private long countDuplets(List<Long> arr, int r) {
		Map<Long, Long> numOfFirstElementsFor = new HashMap<>();
		long numOfDuplets = 0;

		for (long n : arr) {
			Long numOfNewDuplets = numOfFirstElementsFor.get(n);
			if (numOfNewDuplets != null)
				numOfDuplets += numOfNewDuplets;

			numOfFirstElementsFor.compute(n * r, (k, v) -> v == null ? 1 : v + 1);
		}

		return numOfDuplets;
	}
}
