package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj20240206_17206 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] ThreeOrSeven = new int[80_001];

		for (int i = 3; i < 80_001; i++) {
			if (i % 3 == 0 || i % 7 == 0)
				ThreeOrSeven[i] = i + ThreeOrSeven[i - 1];
			else
				ThreeOrSeven[i] = ThreeOrSeven[i - 1];
		}

		int T = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			bw.append(ThreeOrSeven[Integer.parseInt(st.nextToken())] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}
