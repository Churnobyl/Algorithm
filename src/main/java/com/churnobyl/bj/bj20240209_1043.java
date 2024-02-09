package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240209_1043 {
	static int N, M;
	static int[] parent;
	
	static class UnionFind {
		private int[] parent;
		
		public UnionFind(int size) {
			parent = new int[size + 1];
			for (int i = 1; i < size + 1; i++) {
				parent[i] = i;
			}
		}
		
		public int find(int x) {
			if (x == parent[x]) return x;
			
			parent[x] = find(parent[x]);
			return parent[x];
		}
		
		public void union(int a, int b) {
			a = find(a);
			b = find(b);
			
			if (a != b) parent[a] = b;
		}
	}
	
	
	// 독립 집합 찾기. Union-Find 써야함
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		UnionFind uf = new UnionFind(N);
		
		st = new StringTokenizer(br.readLine());
		
		int truthMen = Integer.parseInt(st.nextToken());
		
		int superParent = -1;
		
		for (int i = 0; i < truthMen; i++) {
			int p = Integer.parseInt(st.nextToken());
			
			if (superParent == -1) superParent = p;
			else uf.union(superParent, p);
		}
		
		int[][] parties = new int[M][];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			parties[i] = new int[num];
			for (int j = 0; j < num; j++) {
				parties[i][j] = Integer.parseInt(st.nextToken());
				if (j > 0)
					uf.union(parties[i][0], parties[i][j]);
			}
		}
		
		int count = 0;
		
		for (int i = 0; i < M; i++) {
			boolean lie = true;
			
			for (int j = 0; j < parties[i].length; j++) {
				if (truthMen >0 && uf.find(parties[i][j]) == uf.find(superParent)) {
					lie = false;
					break;
				}
			}
			
			if (lie) count++;
		}
		
		System.out.println(count);
	}
}