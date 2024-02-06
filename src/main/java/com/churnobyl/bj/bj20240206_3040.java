package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj20240206_3040 {
	static int[] a = new int[9];
	static int[] dwarfs;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		dwarfs = new int[7];
		
		for (int i = 0; i < 9; i++) {
			a[i] = Integer.parseInt(br.readLine());
		}
		
		find(bw, dwarfs, 0, 0, 0);
		bw.flush();
		bw.close();
	}
	
	private static void find(BufferedWriter bw, int[] dwarf, int nextIdx, int count, int sum) throws IOException {
		if (7 - count > 9 - nextIdx)
			return;
		
		if (count == 7){
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					bw.append(dwarf[i] + "\n");
				}
			}
			return;
		}
		
		find(bw, dwarf, nextIdx + 1, count, sum);
		
		dwarf[count] = a[nextIdx];
		find(bw, dwarf, nextIdx + 1, count + 1, sum + a[nextIdx]);
	}
}