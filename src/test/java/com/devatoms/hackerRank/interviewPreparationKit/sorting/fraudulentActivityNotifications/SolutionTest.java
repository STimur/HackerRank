package com.devatoms.hackerRank.interviewPreparationKit.sorting.fraudulentActivityNotifications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	private Object[] testData() {
		return new Object[]{
				new Object[]{new int[]{1}, 1, 0},
				new Object[]{new int[]{1, 2}, 1, 1},
				new Object[]{new int[]{1, 4, 4}, 2, 0},
				new Object[]{new int[]{10, 20, 30, 40, 50}, 3, 1}
		};
	}

	@Test
	@Parameters(method = "testData")
	public void activityNotifications(int[] expenditure, int d, int notificationsNumber) {
		assertThat(activityNotifications(expenditure, d), is(notificationsNumber));
	}

	static int activityNotifications(int[] expenditure, int d) {
		int ans = 0;

		for (int i = 0; i + d < expenditure.length; i++) {
			Arrays.sort(expenditure, i, i + d);

			float med = 0;
			if (d % 2 == 0)
				med = (expenditure[i + d / 2] + expenditure[i + d / 2 - 1]) / 2f;
			else
				med = expenditure[i + d / 2];

			if (expenditure[i + d] >= med * 2)
				ans++;
		}
		return ans;
	}
}
