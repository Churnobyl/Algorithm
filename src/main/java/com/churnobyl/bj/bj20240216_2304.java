package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj20240216_2304 {
	static int N, maxHeight, maxIdx;
	static int[] pillar;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		pillar = new int[1001];
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			
			if (maxIdx < idx) {
				maxIdx = idx;
			}
			
			pillar[idx] = height;
		}
		
		int total = 0;
		
		for (int i = 1; i < maxIdx + 1; i++) {
			int data = pillar[i];
			
			if (stack.isEmpty()) {
				maxHeight = data;
				stack.push(data);
				continue;
			}
			
			if (maxHeight >= data) {
				stack.push(data);
			} else {
				while (!stack.isEmpty()) {
					stack.pop();
					total += maxHeight;
				}
				
				stack.push(data);
				maxHeight = data;
			}
		}
		
		int backMax = 0;
		
		while (!stack.isEmpty()) {
			int data = stack.pop();
			if (backMax < data) {
				backMax = data;
				total += data;
			} else {
				total += backMax;
			}
		}
		
		System.out.println(total);
	}
}