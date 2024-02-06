package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj20240206_1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int [101];
		
		for (int i = 1; i < 101; i++) {
			arr[i] = i * i;
		}
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int total = 0;
		int low = Integer.MAX_VALUE;
		boolean flag = false;
		
		for (int i = 1; i < 101; i++) {
			if (flag && arr[i] > M)
				break;
			
			if (N <= arr[i] && arr[i] <= M) {
				if (!flag) {
					low = arr[i];
				}
				
				total += arr[i];
				flag = true;
			}
		}
		
		if (total == 0)
			System.out.println(-1);
		else {
			System.out.println(total);
			System.out.println(low);			
		}
	}
}
