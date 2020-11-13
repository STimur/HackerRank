package com.devatoms.hackerRank.algorithms.implementation.subArrayDivision;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(birthday(Arrays.asList(1), 1, 1)).isEqualTo(1);
		assertThat(birthday(Arrays.asList(1), 1, 2)).isEqualTo(0);
		assertThat(birthday(Arrays.asList(1), 2, 1)).isEqualTo(0);
		assertThat(birthday(Arrays.asList(1, 1, 1, 1, 1, 1), 3, 2)).isEqualTo(0);
		assertThat(birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2)).isEqualTo(2);
		assertThat(birthday(Arrays.asList(1, 2, 1, 3, 2), 3, 2)).isEqualTo(2);
		assertThat(birthday(Arrays.asList(4), 4, 1)).isEqualTo(1);
	}

	static int birthday(List<Integer> s, int d, int m) {
		if (m > s.size())
			return 0;

		int count = 0;
		for (int i = 0; i < s.size() - m + 1; i++) {
			int sum = 0;
			int piecesRemained = m;
			for (int j = i; j < s.size(); j++) {
				sum += s.get(j);
				piecesRemained--;
				if (sum > d)
					break;
				else if (sum == d && piecesRemained == 0) {
					count++;
					break;
				}
			}
		}
		return count;
	}
}
