package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj20240215_9012 {
	static Stack<Character> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < T; i++) {
			stack.clear();
			
			char[] lines = br.readLine().toCharArray();
			boolean flag = true;
			
			for (int j = 0; j < lines.length; j++) {
				if (stack.isEmpty()) {
					if (lines[j] == ')') {
						flag = false;
						break;						
					}
					
					stack.push(lines[j]);
					continue;
				}
				
				if (lines[j] == '(')
					stack.push('(');
				else {
					if (stack.peek() == '(') {
						stack.pop();
					}
				}
			}
			
			if (!flag || !stack.isEmpty())
				bw.append("NO\n");
			else
				bw.append("YES\n");
		}
		
		bw.flush();
		bw.close();
	}
}