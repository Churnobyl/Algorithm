package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj20240206_1236 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] castle = new char[N][M];

		int[] row = new int[N];
		int[] col = new int[M];

		for (int i = 0; i < N; i++) {
			String a = br.readLine();
			
			for (int j = 0; j < M; j++) {
				castle[i][j] = a.charAt(j);
				if (castle[i][j] == 'X') {
					row[i]++;
					col[j]++;
				}
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (row[i] == 0 && col[j] == 0) {
					System.out.println(i + " " + j);
					count++;
					row[i]++;
					col[j]++;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (row[i] == 0 || col[j] == 0) {
					System.out.println(i + " " + j);
					count++;
					row[i]++;
					col[j]++;
				}
			}
		}
		
		bw.append(count + "");
		bw.flush();
		bw.close();
	}
}