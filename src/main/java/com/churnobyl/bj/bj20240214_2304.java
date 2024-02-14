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

public class bj20240214_2304 {
	static int N;
	static int[][] pillar;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		pillar = new int[N][2];
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			pillar[i] = new int[] {idx, height};
		}
		
		Arrays.sort(pillar, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] > o2[0] ? 1 : -1;
			}
			
		});
		
		for (int i = 0; i < N; i++) {			
			System.out.println(Arrays.toString(pillar[i]));
		}
		
	}
}