package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class bj20240206_2851 {
	static int[] arr = new int[46];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int before = 0;
		int now = 0;

		for (int i = 0; i < 10; i++) {
			int a = Integer.parseInt(br.readLine());
			before = now;
			now += a;

			if (now >= 100)
				break;
		}

		if (now - 100 > 100 - before)
			System.out.println(before);
		else if (now - 100 <= 100 - before)
			System.out.println(now);
	}
}