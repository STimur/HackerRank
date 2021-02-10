package com.devatoms.hackerRank.interviewPreparationKit.hashmaps.countTriplets;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(countTriplets(Arrays.asList(1L), 1)).isEqualTo(0);
		assertThat(countTriplets(Arrays.asList(1L, 2L, 4L), 2)).isEqualTo(1);
		assertThat(countTriplets(Arrays.asList(1L, 2L, 4L), 3)).isEqualTo(0);
	}

	static long countTriplets(List<Long> arr, long r) {
		if (arr.size() < 3)
			return 0;

		return (arr.get(0) * r == arr.get(1) && arr.get(1) * r == arr.get(2)) ? 1 : 0;
	}
}
