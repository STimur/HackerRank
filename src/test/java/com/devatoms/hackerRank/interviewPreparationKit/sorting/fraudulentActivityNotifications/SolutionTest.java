package com.devatoms.hackerRank.interviewPreparationKit.sorting.fraudulentActivityNotifications;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(JUnitParamsRunner.class)
public class SolutionTest {

	private Object[] testDataForActivityNotifications() {
		return new Object[]{
				new Object[]{new int[]{1}, 1, 0},
				new Object[]{new int[]{1, 2}, 1, 1},
				new Object[]{new int[]{1, 4, 4}, 2, 0},
				new Object[]{new int[]{10, 20, 30, 40, 50}, 3, 1}
		};
	}

	private Object[] testDataForGetMedian() {
		int[] count = new int[31];
		count[10] = count[20] = count[30] = 1;

		return new Object[]{
				new Object[]{new int[]{0, 1}, 1, 1.0f},
				new Object[]{new int[]{0, 1, 0, 0, 1}, 2, 2.5f},
				new Object[]{count, 3, 20.0f}
		};
	}

	@Test
	@Parameters(method = "testDataForActivityNotifications")
	public void activityNotifications(int[] expenditure, int d, int notificationsNumber) {
		assertThat(activityNotifications(expenditure, d), is(notificationsNumber));
	}

	@Test
	@Parameters(method = "testDataForGetMedian")
	public void getMedian(int[] count, int d, float median) {
		assertThat(getMedian(count, d), is(median));
	}

	static int activityNotifications(int[] expenditure, int d) {
		int ans = 0;
		int[] count = new int[201];

		for (int i = 0; i < d; i++)
			count[expenditure[i]]++;

		for (int i = d; i < expenditure.length; i++) {
			float med = getMedian(count, d);

			if (expenditure[i] >= med * 2)
				ans++;

			count[expenditure[i]]++;
			count[expenditure[i - d]]--;
		}
		return ans;
	}

	private static float getMedian(int[] count, int d) {
		float med = 0;

		if (d % 2 == 0) {
			int numOfElems = 0;
			int m1 = -1;
			int m2 = -1;

			for (int i = 0; i < count.length; i++) {
				numOfElems += count[i];
				if (m1 == -1 && numOfElems >= d / 2)
					m1 = i;
				if (m2 == -1 && numOfElems >= d / 2 + 1) {
					m2 = i;
					break;
				}
			}
			med = (m1 + m2) / 2.0f;
		} else {
			int numOfElems = 0;

			for (int i = 0; i < count.length; i++) {
				numOfElems += count[i];
				if (numOfElems > d / 2) {
					med = i;
					break;
				}
			}
		}

		return med;
	}
}
