package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240206_1681 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int count = 0;
		int i = 1;
		
		while (count != N) {
			int t = i;
			
			int divCount = 1;
			
			boolean haveIt = false;
			
			while (t != 0) {
				int remain = t % 10;
				if (remain == L) {
					i += Math.pow(10, divCount - 1);
					haveIt = true;
					break;
				}
				
				divCount++;
				t /= 10;
			}
			
			if (!haveIt) {
				count++;
				i++;
			}
		}
		
		System.out.println(i - 1);
		
	}
}