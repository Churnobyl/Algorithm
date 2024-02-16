package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Stack;

public class bj20240216_2504 {
	static Stack<int[]> braStack = new Stack<>();
	static Stack<int[]> valueStack = new Stack<>();	
	static HashMap<Character, Character> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char[] lines = br.readLine().toCharArray();

		map.put(')', '(');
		map.put(']', '[');
		
		int depth = 0;
		boolean flag = true;

		for (int i = 0; i < lines.length; i++) {
			char data = lines[i];
			
			if (data == '(' || data == '[') {
				depth++;
				braStack.push(new int[] {depth, data});
			} else { // 닫는 경우
				if (braStack.isEmpty()) {
					// 비어있는 경우 말 안됨 0임
					flag = false;
					break;
				}
				
				if (map.get(data) == braStack.peek()[1]) {
					int[] braData = braStack.pop();
					
					if (valueStack.isEmpty()) {
						if (braData[1] == '(')
							valueStack.push(new int[] {braData[0], 2});
						else if (braData[1] == '[')
							valueStack.push(new int[] {braData[0], 3});
					} else {
						
						int total = 0;
						
						while (!valueStack.isEmpty() && valueStack.peek()[0] > depth) {
							total += valueStack.pop()[1];
						}
						
						if (total == 0) {
							if (braData[1] == '(')
								valueStack.push(new int[] {braData[0], 2});
							else if (braData[1] == '[')
								valueStack.push(new int[] {braData[0], 3});
						} else {
							if (braData[1] == '(')
								valueStack.push(new int[] {depth, total * 2});
							else if (braData[1] == '[')
								valueStack.push(new int[] {depth, total * 3});
						}
					}
					
				} else {
					// 괄호 순서 다름 말 안됨
					flag = false;
					break;
				}
				
				depth--;
			}
		}
		
		if (braStack.isEmpty() && flag) {
			int total = 0;
			
			while (!valueStack.isEmpty()) {
				total += valueStack.pop()[1];
			}
			
			bw.append(total + "");
			bw.flush();
		} else {
			bw.append("0");
		}
		
		
		bw.close();
	}
}