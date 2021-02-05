package com.devatoms.hackerRank.interviewPreparationKit.hashmaps.countTriplets;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(countTriplets(Arrays.asList(1L), 1)).isEqualTo(0);
		assertThat(countTriplets(Arrays.asList(1L, 1L, 1L), 1)).isEqualTo(1);
		assertThat(countTriplets(Arrays.asList(1L, 1L, 1L, 1L), 1)).isEqualTo(4);
	}

	static long countTriplets(List<Long> arr, long r) {
		Map<Long, Long> numOfFirstElementsFor = new HashMap<>();
		Map<Long, Long> numOfDupletsFor = new HashMap<>();
		long count = 0;

		for (long n : arr) {
			final Long numOfNewTriplets = numOfDupletsFor.get(n);
			if (numOfNewTriplets != null)
				count += numOfNewTriplets;

			final Long numOfNewDuplets = numOfFirstElementsFor.get(n);
			if (numOfNewDuplets != null) {
				final Long currentNumOfDuplets = numOfDupletsFor.get(n * r);
				if (currentNumOfDuplets == null)
					numOfDupletsFor.put(n * r, numOfNewDuplets);
				else
					numOfDupletsFor.put(n * r, currentNumOfDuplets + numOfNewDuplets);
			}

			final Long currentNumOfFirstElements = numOfFirstElementsFor.get(n * r);
			if (currentNumOfFirstElements == null)
				numOfFirstElementsFor.put(n * r, 1L);
			else
				numOfFirstElementsFor.put(n * r, currentNumOfFirstElements + 1);
		}

		return count;
	}
}
