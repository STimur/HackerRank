package com.devatoms.hackerRank.interviewPreparationKit.sorting.comparator;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void compare_first_is_greater() {
		Player a = new Player("a", 0);
		Player b = new Player("b", 1);

		Checker checker = new Checker();

		assertThat(checker.compare(a, b), is(1));
	}

	class Player {
		String name;
		int score;

		Player(String name, int score) {
			this.name = name;
			this.score = score;
		}
	}

	class Checker implements Comparator<Player> {
		public int compare(Player a, Player b) {
			return 1;
		}
	}
}
