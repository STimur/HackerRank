package com.devatoms.hackerRank.java.introduction.endOfFile;

import java.util.Scanner;

public class Solution {

	public static void main(String[] argh) {
		Scanner sc = new Scanner(System.in);
		int i = 1;
		while (sc.hasNextLine()) {
			System.out.println(i++ + " " + sc.nextLine());
		}
		sc.close();
	}
}
