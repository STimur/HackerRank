package com.devatoms.hackerRank.algorithms.implementation.pickingNumbers;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(pickingNumbers(Arrays.asList(1, 1))).isEqualTo(2);
		assertThat(pickingNumbers(Arrays.asList(1, 1, 3))).isEqualTo(2);
		assertThat(pickingNumbers(Arrays.asList(7, 1, 1))).isEqualTo(2);
		assertThat(pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5))).isEqualTo(5);
		assertThat(pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1))).isEqualTo(3);
		assertThat(pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2))).isEqualTo(5);
		assertThat(pickingNumbers(Arrays.asList(1, 1, 3, 3, 1, 1, 5))).isEqualTo(4);
	}

	public static int pickingNumbers(List<Integer> a) {
		Collections.sort(a);
		int temp = 1;
		int max = 2;
		int start = 0;

		for (int i = 1; i < a.size(); i++) {
			if (Math.abs(a.get(start) - a.get(i)) <= 1)
				temp++;
			else {
				start = i;
				if (temp > max)
					max = temp;
				temp = 1;
			}
		}
		if (temp > max)
			max = temp;

		return max;
	}
}
