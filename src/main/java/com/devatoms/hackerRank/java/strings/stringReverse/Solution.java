package com.devatoms.hackerRank.java.strings.stringReverse;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.next();
		if (new StringBuilder(A).reverse().toString().equals(A))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
