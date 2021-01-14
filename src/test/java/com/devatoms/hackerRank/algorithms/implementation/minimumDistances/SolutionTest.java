package com.devatoms.hackerRank.algorithms.implementation.minimumDistances;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(minimumDistances(new int[]{1})).isEqualTo(-1);
		assertThat(minimumDistances(new int[]{1, 1})).isEqualTo(1);
		assertThat(minimumDistances(new int[]{1, 2, 1})).isEqualTo(2);
		assertThat(minimumDistances(new int[]{7, 1, 3, 4, 1, 7})).isEqualTo(3);
	}

	static int minimumDistances(int[] a) {
		if (a.length == 1)
			return -1;

		Map<Integer, List<Integer>> eqValIndexes = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (eqValIndexes.get(a[i]) == null) {
				eqValIndexes.put(a[i], new ArrayList<>());
				eqValIndexes.get(a[i]).add(i);
			} else
				eqValIndexes.get(a[i]).add(i);
		}

		int minDist = 100000;
		for (List<Integer> list : eqValIndexes.values())
			for (int i = 0; i < list.size() - 1; i++) {
				int minDistCandidate = list.get(i + 1) - list.get(i);
				if (minDistCandidate < minDist)
					minDist = minDistCandidate;
			}

		return minDist == 100000 ? -1 : minDist;
	}
}
