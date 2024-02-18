package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class bj20240214_1966 {
	static int N, M;
	static Queue<int[]> queue = new LinkedList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		
		for (int i = 0; i < T; i++) {
			queue.clear();
			map.clear();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				int data = Integer.parseInt(st.nextToken());
				queue.add(new int[] {j, data});
				map.put(data, map.getOrDefault(data, 0) + 1);
			}
			
			Set<Map.Entry<Integer, Integer>> entryset = map.entrySet();
			entryset.stream().sorted();
		}
	}
}