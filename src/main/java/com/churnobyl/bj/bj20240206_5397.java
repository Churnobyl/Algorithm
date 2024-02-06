package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class bj20240206_5397 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			LinkedList<Character> l = new LinkedList<>();
			ListIterator<Character> iterator = l.listIterator();

			for (int j = 0; j < s.length(); j++) {
				char d = s.charAt(j);

				if (d == '<') {
					if (iterator.hasPrevious())
						iterator.previous();
				} else if (d == '>') {
					if (iterator.hasNext())
						iterator.next();
				} else if (d == '-') {
					if (iterator.hasPrevious()) {
						iterator.previous();
						iterator.remove();
					}
				} else {
					iterator.add(d);
				}
			}
			
			for (Object a : l.toArray()) {
				bw.append((char) a);
			}
			bw.append("\n");

		}

		bw.flush();
		bw.close();
	}
}