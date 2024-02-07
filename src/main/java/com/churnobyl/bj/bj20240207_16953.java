package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240207_16953 {
	static HashMap<Integer, Integer> dp;
	static int A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		dp = new HashMap<>();
		
		System.out.println(bfs() + 1);
	}
	
	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {A, 0});
		
		while (!queue.isEmpty()) {
			int[] nxt = queue.poll();
			
			dp.put(nxt[0], dp.getOrDefault(nxt[0], 0) + 1);
			
			if (nxt[0] == B) {
				return nxt[1];
			}
			
			if (nxt[0] * 2 <= B && nxt[1] + 1 < dp.getOrDefault(nxt[0] * 2, Integer.MAX_VALUE)) {
				queue.add(new int[] {nxt[0] * 2, nxt[1] + 1});
			}
			
			if (nxt[0] > Integer.MAX_VALUE / 10)
				continue;
			
			if (nxt[0] * 10 + 1 <= B && nxt[1] + 1 < dp.getOrDefault(nxt[0] * 10 + 1, Integer.MAX_VALUE)) {
				queue.add(new int[] {nxt[0] * 10 + 1, nxt[1] + 1});
			}
		}
		
		return -2;
	}
}