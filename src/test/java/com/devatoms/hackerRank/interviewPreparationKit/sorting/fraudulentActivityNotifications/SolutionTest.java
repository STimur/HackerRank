package com.devatoms.hackerRank.interviewPreparationKit.sorting.fraudulentActivityNotifications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	private Object[] testData() {
		return new Object[] {
				new Object[]{new int[]{1}, 1, 0}
		};
	}

	@Test
	@Parameters(method = "testData")
	public void activityNotifications(int[] expenditure, int d, int notificationsNumber) {
		assertThat(activityNotifications(expenditure, d), is(notificationsNumber));
	}

	static int activityNotifications(int[] expenditure, int d) {
		return 0;
	}
}
