package com.devatoms.hackerRank.interviewPreparationKit.sorting.comparator;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Comparator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	private Object[] testData() {
		return new Object[] {
				new Object[]{new Player("a", 0), new Player("a", 1), 1},
				new Object[]{new Player("a", 0), new Player("a", 0), 0},
				new Object[]{new Player("a", 1), new Player("a", 0), -1},

				new Object[]{new Player("a", 0), new Player("b", 0), -1},
				new Object[]{new Player("a", 0), new Player("a", 0), 0},
				new Object[]{new Player("b", 0), new Player("a", 0), 1},

				new Object[]{new Player("a", 0), new Player("b", 1), 1}
		};
	}

	@Test
	@Parameters(method = "testData")
	public void compare(Player a, Player b, int result) {
		assertThat(new Checker().compare(a, b), is(result));
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

			if (a.score == b.score)
				return a.name.compareTo(b.name);

			return b.score - a.score;
		}
	}
}
