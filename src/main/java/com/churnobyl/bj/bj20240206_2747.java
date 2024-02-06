package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj20240206_2747 {
	static int[] arr = new int[46];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		bw.append(fibo(n) + "");
		
		bw.flush();
		bw.close();
	}
	
	private static int fibo(int n) {
		if (n < 2) return n;
		
		if (arr[n] != 0)
			return arr[n];
		else
			arr[n] = fibo(n - 1) + fibo(n - 2);
		
		return arr[n];
	}
}