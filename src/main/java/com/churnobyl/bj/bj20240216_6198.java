package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj20240216_6198 {
	static int N;
	static int[] building;
	static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		building = new int[N];

		for (int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}

		long total = 0;

		for (int i = 0; i < N; i++) {
			int data = building[i];

			if (stack.isEmpty()) {
				stack.push(data);
				continue;
			}

			if (stack.peek() > data) {
				stack.push(data);
			} else {
				while (!stack.isEmpty() && stack.peek() <= data) {
					stack.pop();
					total += stack.size();
				}
				stack.push(data);
			}
		}
		
		int count = 0;
		
		while (!stack.isEmpty()) {
			stack.pop();
			total += count;
			count++;
		}

		System.out.println(total);
	}
}