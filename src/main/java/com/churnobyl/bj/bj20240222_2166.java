package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240222_2166 {
	static long[] strap = new long[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] first = {Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())};
		long[] before = new long[2];
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			long l = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			
			if (i == 1) {
				strap[1] += first[1] * l;
				strap[0] += first[0] * r;
				
				before[0] = l;
				before[1] = r;
				continue;
			}
			
			strap[1] += before[1] * l;
			strap[0] += before[0] * r;
			
			before[0] = l;
			before[1] = r;
		}
		
		strap[1] += before[1] * first[0];
		strap[0] += before[0] * first[1];
		
		double result = Math.abs(strap[1] - strap[0]) / (double)2;
//		result = Math.round(result * 10) / 10;
		System.out.println(String.format("%.1f", result));
	}
}