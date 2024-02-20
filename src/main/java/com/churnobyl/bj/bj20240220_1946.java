package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class bj20240220_1946 {
	static int N;
	static int[][] candidates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());
			candidates = new int[N][2];
			
			for (int j = 0; j < N; j++) {
				candidates[j] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			Arrays.sort(candidates, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o1[0] > o2[0]) return 1;
					else return -1;
				}
			});
			
			int count = 1;
			int beforeRank = candidates[0][1];
			
			for (int j = 0; j < N; j++) {
				if (candidates[j][1] < beforeRank) {
					count++;
					beforeRank = candidates[j][1];
				}
			}
			
			System.out.println(count);
		}
    }
}