package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj20240205_2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean flag = false;

		for (int i = 0; i < N; i++) {
			int total = i;
			
			int b = i;

			while (b != 0) {
				total += b % 10;
				b /= 10;
			}

			if (total == N) {
				System.out.println(i);
				flag = true;
				break;
			}
		}

		if (!flag)
			System.out.println(0);
	}
}
