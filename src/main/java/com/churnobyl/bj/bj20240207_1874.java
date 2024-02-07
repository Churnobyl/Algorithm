package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj20240207_1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		int waitNum = 0; 
		int nextNum = -1;
		boolean flag = true;
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) {
			nextNum = Integer.parseInt(br.readLine());
			
			if (!stack.isEmpty() && stack.peek() == nextNum) {
				stack.pop();
				sb.append("-\n");
			} else if (nextNum > waitNum) {
				do {
					waitNum++;
					stack.push(waitNum);
					sb.append("+\n");
				} while (waitNum != nextNum);
				
				stack.pop();
				sb.append("-\n");
			} else {
				flag = false;
				break;
			}
		}
		
		if (flag) {
			System.out.println(sb);
		} else {
			System.out.println("NO");
		}
	}
}