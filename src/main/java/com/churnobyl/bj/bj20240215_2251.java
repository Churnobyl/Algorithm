package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj20240215_2251 {
	static int A, B, C;
	static boolean[] visited;
	static int[] capacity;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		visited = new boolean[C + 1];
		capacity = new int[] {A, B, C};
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.add(new int[] {0, 0, C}); // A cur, A max, B cur, B max, C cur, C max, state
		
		// A -> B : 1, A -> C : 2, B -> A : 3, B -> C : 4, C -> A : 5, C -> B : 6
		while (!queue.isEmpty()) {
			System.out.println(Arrays.toString(visited));
			
			int[] data = queue.poll();

			if (visited[data[2]])
				continue;
			
			visited[data[2]] = true;
			
			for (int i = 0; i < 3; i++) {
				if (data[i] == 0)
					continue;
				
				for (int j = 0; j < 3; j++) {
					if (i == j || capacity[j] == data[j]) continue;
//
//					if (data[i] >= 
//					
//					int b = capacity[j] - ;
//					int a = 0;
//					
//					int[] newData = data.clone();
//					newData[i] = a;
//					newData[j] = b;
//					
//					queue.add(newData);
				}
			}
		}
	}
}