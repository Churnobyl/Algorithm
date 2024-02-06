package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj20240206_2702 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int g = gcd(a, b);
			
			bw.append(String.format("%d %d%n", a * b / g, g));
		}
		
		bw.flush();
		bw.close();
	}
	
	private static int gcd(int a, int b) {
		if (a < b) {
			int cache = a;
			a = b;
			b = cache;
		}
		
		if (a % b == 0)
			return b;
		else
			return gcd(b, a % b);
	}
}