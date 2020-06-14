package com.devatoms.hackerRank.algorithms.implementation.gradingStudents;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void ancillary() {
		assertThat(0 % 5).isEqualTo(0);
		assertThat(1 % 5).isEqualTo(1);
		assertThat(4 % 5).isEqualTo(4);
		assertThat(5 % 5).isEqualTo(0);
		assertThat(37 % 5).isEqualTo(2);
		assertThat(38 % 5).isEqualTo(3);
		assertThat(41 % 5).isEqualTo(1);
		assertThat(40 % 5).isEqualTo(0);
		assertThat(38 / 5.0).isEqualTo(7.6);
		assertThat(37 / 5.0).isEqualTo(7.4);
		assertThat(35 / 5.0).isEqualTo(7);
		assertThat(36 / 5.0).isEqualTo(7.2);
		assertThat(39 / 5.0).isEqualTo(7.8);
		assertThat(40 / 5.0).isEqualTo(8);
	}

	@Test
	public void solution() {
		assertThat(gradingStudents(Arrays.asList(37, 38, 73, 67))).isEqualTo(Arrays.asList(37, 40, 75, 67));
	}

	public static List<Integer> gradingStudents(List<Integer> grades) {
		return grades.stream().map(i -> (i % 5 > 2 && i > 37) ? (5 * Math.round(i / 5.0f)) : i).collect(Collectors.toList());
	}
}
