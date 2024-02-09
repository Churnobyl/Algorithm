package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class bj20240206_3015 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<int[]> stack = new Stack<>();
		long count = 0;
		
		for (int i = 0; i < N; i++) {
			int person = Integer.parseInt(br.readLine());
			
			while (!stack.isEmpty() && stack.peek()[0] < person) {
				count += stack.pop()[1];
			}
			
			if (!stack.isEmpty() && stack.peek()[0] == person) {
				int[] before = stack.pop();
				count += before[1];
				
				if (!stack.isEmpty()) {
					count += 1;
				}
				stack.push(new int[] {person, before[1] + 1});
			} else {
				if (!stack.isEmpty()) {
					count += 1;
				}
				
				stack.push(new int[] {person, 1});
			}
		}
		
		System.out.println(count);
	}
}