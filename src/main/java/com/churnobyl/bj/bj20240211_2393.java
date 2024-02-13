package com.churnobyl.bj;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class bj20240211_2393 {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		bw.append("  ___  ___  ___\n"
				+ "  | |__| |__| |\n"
				+ "  |           |\n"
				+ "   \\_________/\n"
				+ "    \\_______/\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |     |\n"
				+ "     |_____|\n"
				+ "  __/       \\__\n"
				+ " /             \\\n"
				+ "/_______________\\");
		bw.flush();
		bw.close();
	}
	
}