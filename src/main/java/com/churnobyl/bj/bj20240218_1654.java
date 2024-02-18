package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240218_1654 {
	static int N, K;
	static long maximumLine;
	static long[] lanLine;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		lanLine = new long[N];
		maximumLine = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			lanLine[i] = Long.parseLong(br.readLine());
			if (maximumLine < lanLine[i]) maximumLine = lanLine[i];
		}
		findBoundary(0, maximumLine);
		
	}
	
	private static void findBoundary(long l, long r) {
		if (l > r) {
			System.out.println(r);
			return;
		}
				
		int total = 0;
		
		long mid = (l + r) / 2;
		
		for (int i = 0; i < N; i++) {
			total += lanLine[i] / mid;
		}
		
		if (K > total) {
			findBoundary(l, mid - 1);
		} else {
			findBoundary(mid + 1, r);
		}
	}
}