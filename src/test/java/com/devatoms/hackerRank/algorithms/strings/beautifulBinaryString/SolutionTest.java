package com.devatoms.hackerRank.algorithms.strings.beautifulBinaryString;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

	@Test
	public void solution() {
		assertThat(beautifulBinaryString("0"), is(0));
		assertThat(beautifulBinaryString("010"), is(1));
		assertThat(beautifulBinaryString("0101010"), is(2));
		assertThat(beautifulBinaryString("010010101010001011010"), is(5));
	}

	static int beautifulBinaryString(String b) {
		int res = 0;
		for (int i = 0; (i = b.indexOf("010", i)) != -1; res++, i += 3) ;
		return res;
	}
}
