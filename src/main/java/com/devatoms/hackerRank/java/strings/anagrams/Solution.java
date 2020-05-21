package com.devatoms.hackerRank.java.strings.anagrams;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static boolean isAnagram(String a, String b) {
		int[] dict = new int[26];

		for (char c : a.toLowerCase().toCharArray())
			dict[c - 97]++;
		for (char c : b.toLowerCase().toCharArray())
			dict[c - 97]--;

		int sum = 0;
		for (int i : dict)
			if (i != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String a = scan.next();
		String b = scan.next();
		scan.close();
		boolean ret = isAnagram(a, b);
		System.out.println((ret) ? "Anagrams" : "Not Anagrams");
	}
}
