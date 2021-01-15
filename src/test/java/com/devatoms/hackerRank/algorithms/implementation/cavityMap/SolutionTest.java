package com.devatoms.hackerRank.algorithms.implementation.cavityMap;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SolutionTest {

	@Test
	public void ancillary() {
		assertThat(Character.getNumericValue('1')).isEqualTo(1);
		assertThat(Character.getNumericValue('5')).isEqualTo(5);
		assertThat(Character.getNumericValue('9')).isEqualTo(9);
	}

	@Test
	public void solution() {
		assertThat(cavityMap(new String[]{"989", "191", "111"})).isEqualTo(new String[]{"989", "1X1", "111"});
		assertThat(cavityMap(new String[]{"1112", "1912", "1892", "1234"})).isEqualTo(new String[]{"1112", "1X12", "18X2", "1234"});
	}

	static String[] cavityMap(String[] grid) {
		for (int i = 1; i < grid.length - 1; i++)
			for (int j = 1; j < grid.length - 1; j++) {
				int cellValue = Character.getNumericValue(grid[i].charAt(j));
				int topCellValue = Character.getNumericValue(grid[i - 1].charAt(j));
				int rightCellValue = Character.getNumericValue(grid[i].charAt(j + 1));
				int bottomCellValue = Character.getNumericValue(grid[i + 1].charAt(j));
				int leftCellValue = Character.getNumericValue(grid[i].charAt(j - 1));
				if (cellValue > topCellValue && cellValue > rightCellValue
						&& cellValue > bottomCellValue && cellValue > leftCellValue)
					grid[i] = grid[i].substring(0, j) + 'X' + grid[i].substring(j + 1, grid.length);
			}
		return grid;
	}
}
