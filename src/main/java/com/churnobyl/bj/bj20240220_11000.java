package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 전략 : 시간 순서대로 배치하기 위해 정렬 이용, 여러 개의 강의실 중 끝나는 시간이 가장 빠른 것을 찾기 위해 우선순위큐 사용
 */
public class bj20240220_11000 {
	static int N;
	static int[][] classes;
	static Queue<Integer> queue = new PriorityQueue<>(); 
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        
        classes = new int[N][2];
        
        for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			classes[i][0] = Integer.parseInt(st.nextToken());
			classes[i][1] = Integer.parseInt(st.nextToken());
		}
        
        Arrays.sort(classes, (a, b) -> Integer.compare(a[0], b[0]));
        
        int maxValue = 0;
        
        for (int i = 0; i < N; i++) {
			if (queue.isEmpty()) {
				queue.add(classes[i][1]);
				maxValue++;
				continue;
			}
			
			if (queue.peek() <= classes[i][0]) {
				queue.poll();				
				queue.add(classes[i][1]);
			} else {
				queue.add(classes[i][1]);
				maxValue++;
			}
		}
        
        System.out.println(maxValue);
    }
}