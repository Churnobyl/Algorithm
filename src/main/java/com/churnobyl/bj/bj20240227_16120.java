package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj20240227_16120 {
	static Stack<Character> stack = new Stack<>();
	static Stack<Character> subStack = new Stack<>();
	static char[] ppap = new char[] {'P', 'P', 'A', 'P'};
	static int state = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String line = br.readLine();
		
		for (int i = 0; i < line.length(); i++) {
			char d = line.charAt(i);
			
			if (stack.size() < 3) {
				stack.push(d);
				continue;
			}
			
			if (d == 'P' && stack.peek() == 'A') {
				subStack.push(stack.pop());
				
				boolean flag = true;
				
				for (int j = 0; j < 2; j++) {
					char wantP = stack.pop();
					subStack.push(wantP);
					if (wantP != 'P') {
						flag = false;
						while (!subStack.isEmpty()) {
							stack.push(subStack.pop());
						}
					}
				}
				
				if (flag) {
					subStack.clear();
					stack.push(d);
				} else {
					stack.push(d);
				}
				
			} else {
				stack.push(d);
			}
		}
//		
//		while (!stack.isEmpty())
		
		
		System.out.println(stack);
	}
}