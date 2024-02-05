package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj20240225_2292 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int total = 1;
		int idx = 1;
		
		
		while (N > total) {
			total += 6 * idx;
			idx++;
		}
		
		System.out.println(idx);
	}
}
