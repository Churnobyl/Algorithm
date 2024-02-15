package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240215_1268 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		int[][] students = new int[N + 1][5];
		boolean[][] check = new boolean[N + 1][N + 1];
		
		StringTokenizer st;
		
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < 5; j++) {
				students[i][j] = Integer.parseInt(st.nextToken());
				
				for (int j2 = 1; j2 < i; j2++) {
					if (students[i][j] == students[j2][j]) {
						check[i][j2] = true;
						check[j2][i] = true;
					}
				}
			}
		}
		
		int maxValue = 0;
		int maxStudent = 1;
		
		for (int i = 1; i < N + 1; i++) {
			int cache = 0;
			
			for (int j = 1; j < N + 1; j++) {
				if (check[i][j]) cache++;
			}
			
			if (maxValue < cache) {
				maxValue = cache;
				maxStudent = i;
			}
		}
		
		System.out.println(maxStudent);
	}
}