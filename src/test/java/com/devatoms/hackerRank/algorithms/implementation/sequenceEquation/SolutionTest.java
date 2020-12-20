package com.devatoms.hackerRank.algorithms.implementation.sequenceEquation;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(permutationEquation(new int[]{1})).isEqualTo(new int[]{1});
		assertThat(permutationEquation(new int[]{2, 1})).isEqualTo(new int[]{1, 2});
		assertThat(permutationEquation(new int[]{2, 3, 1})).isEqualTo(new int[]{2, 3, 1});
		assertThat(permutationEquation(new int[]{4, 3, 5, 1, 2})).isEqualTo(new int[]{1, 3, 5, 4, 2});
	}

	static int[] permutationEquation(int[] p) {
		int[] res = new int[p.length];

		for (int i = 1; i <= p.length; i++)
			for (int j = 0; j < p.length; j++)
				if (i == p[j])
					for (int k = 0; k < p.length; k++)
						if (j + 1 == p[k])
							res[i - 1] = k + 1;

		return res;
	}
}
