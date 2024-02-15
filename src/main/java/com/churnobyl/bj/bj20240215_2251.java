package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class bj20240215_2251 {
	static int A, B, C, zero;
	static boolean[][][] visited;
	static int[] capacity;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[A + 1][B + 1][C + 1];
		capacity = new int[] {A, B, C};
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0, C}); // A cur, A max, B cur, B max, C cur, C max, state
		
		// A -> B : 1, A -> C : 2, B -> A : 3, B -> C : 4, C -> A : 5, C -> B : 6
		while (!queue.isEmpty()) {
			int[] data = queue.poll();

			if (visited[data[0]][data[1]][data[2]]) continue;
			
			if (data[0] == 0 && !visited[data[0]][data[1]][data[2]]) {
				set.add(data[2]);
			}
			
			visited[data[0]][data[1]][data[2]] = true;
			
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (i == j) continue;

					int[] newData = data.clone();
					
					int move = Math.min(data[i], capacity[j] - data[j]);
					newData[i] -= move;
					newData[j] += move;
					
					queue.add(newData);
				}
			}
		}
		
		ArrayList<Integer> result = new ArrayList<>(set);
		
		Collections.sort(result);
		
		for (Object a : result) {
			bw.append((int) a + " ");
		}
		
		bw.flush();
		bw.close();
	}
}