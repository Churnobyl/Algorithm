package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240206_1037 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			if (low > a) low = a;
			if (high < a) high = a;
		}
		
		System.out.println(low * high);
	}
}
