package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj20240214_14003 {
	static int N;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = new int[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(Arrays.toString(divAndConquer(0, N - 1)));
	}
	
	private static int[] divAndConquer(int s, int e) {
		if (e - s == 0) {
			return new int[] {A[s]};
		}
		
		int[] left = divAndConquer(s, (s + e) / 2);
		int[] right = divAndConquer((s + e) / 2 + 1, e);
		System.out.println(s + " " + e);
		System.out.println(Arrays.toString(left));
		System.out.println(Arrays.toString(right));
		
		int lSize = left.length;
		int rSize = right.length;

		int[] newArr;
		
		if (lSize >= rSize) {
			int i = 0;
			
			while (i < rSize && left[lSize - 1] >= right[i]) {
				i++;
			}
			
			newArr = new int[lSize + rSize - i];
			System.arraycopy(left, 0, newArr, 0, lSize);
			System.arraycopy(right, i, newArr, lSize, rSize - i);
		} else {
			int i = lSize - 1;
			
			while (i > 0 && right[rSize - 1] > left[i]) {
				i--;
			}
			
			newArr = new int[i + rSize];
			System.arraycopy(left, 0, newArr, 0, i);
			System.arraycopy(right, 0, newArr, i, rSize);
		}
		
		return newArr;
	}
}