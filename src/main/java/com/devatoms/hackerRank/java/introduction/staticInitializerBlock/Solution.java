package com.devatoms.hackerRank.java.introduction.staticInitializerBlock;

import java.util.Scanner;

public class Solution {

	static int B, H;
	static boolean flag;

	static {
		Scanner in = new Scanner(System.in);
		B = in.nextInt();
		H = in.nextInt();
		try {
			if (B <= 0 || H <= 0)
				throw new Exception("Breadth and height must be positive");
			flag = true;
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args){
		if(flag){
			int area=B*H;
			System.out.print(area);
		}

	}//end of main

}//end of class

/*
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int B = in.nextInt(), H = in.nextInt();
		try {
			if (B <= 0 || H <= 0)
				throw new Exception("Breadth and height must be positive");
			int area = B * H;
			System.out.print(area);
		} catch (Exception e) {
			System.out.println(e);
		}

	}//end of main

}//end of class
 */
