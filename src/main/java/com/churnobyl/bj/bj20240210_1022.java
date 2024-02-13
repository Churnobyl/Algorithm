package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class bj20240210_1022 {

	static int r1, c1, r2, c2;
	static int[][] swirl;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		r1 = Integer.parseInt(st.nextToken());
		c1 = Integer.parseInt(st.nextToken());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		swirl = new int[r2 - r1 + 1][c2 - c1 + 1];

		makeSwirl(bw);
	}

	private static void makeSwirl(BufferedWriter bw) throws IOException {
		int maxNum = 0;

		for (int i = r1; i <= r2; i++) {
			for (int j = c1; j <= c2; j++) {
				int cache = calcSwirl(i, j);
				maxNum = Math.max(maxNum, cache);
				swirl[i - r1][j - c1] = cache;
			}
		}

		int maxLength = String.valueOf(maxNum).length();

		for (int i = 0; i < r2 - r1 + 1; i++) {
			for (int j = 0; j < c2 - c1 + 1; j++) {
				bw.append(String.format("%" + maxLength + "d ", swirl[i][j]));
			}
			bw.append("\n");
		}

		bw.flush();
		bw.close();
	}

	private static int calcSwirl(int r, int c) {
		int maxSquare = Math.max(Math.abs(r), Math.abs(c));
		int maxNum = (maxSquare * 2 + 1) * (maxSquare * 2 + 1);

		if (r == maxSquare) { // bottom
			return maxNum - (maxSquare - c);
		}
		
		maxNum -= 2 * maxSquare;
		
		if (c == -maxSquare) { // left
			return maxNum - (maxSquare - r);
		}
		
		maxNum -= 2 * maxSquare;
		
		if (r == -maxSquare) { // top
			return maxNum - (maxSquare + c);
		}
		
		maxNum -= 2 * maxSquare;

		return maxNum - (maxSquare + r);
	}
}