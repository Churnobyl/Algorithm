package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240209_9019 {
	static int A, B;
	static boolean[] visited;
	
	static class NumAndString {
		int num;
		String com;
		
		public NumAndString(int num, String com) {
			super();
			this.num = num;
			this.com = com;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			bw.append(dfs(A, B) + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
	private static String dfs(int A, int B) {
		Queue<NumAndString> queue = new LinkedList<>();
		visited = new boolean[10000];
		
		queue.add(new NumAndString(A, ""));
		
		while (!queue.isEmpty()) {
			NumAndString nxt = queue.poll();
			
			if (visited[nxt.num])
				continue;
			
			visited[nxt.num] = true;
			
			if (nxt.num == B) {
				return nxt.com;
			}
			
			int D = (nxt.num * 2) % 10_000;
			int S = (nxt.num == 0) ? 9999 : nxt.num - 1;
			int L = (nxt.num % 1_000) * 10 + nxt.num / 1000;
			int R = (nxt.num % 10) * 1000 + nxt.num / 10;
			
			if (!visited[D]) queue.add(new NumAndString(D, nxt.com + "D"));
			if (!visited[S]) queue.add(new NumAndString(S, nxt.com + "S"));
			if (!visited[L]) queue.add(new NumAndString(L, nxt.com + "L"));
			if (!visited[R]) queue.add(new NumAndString(R, nxt.com + "R"));
		}
		
		return "";
	}
}