package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj20240222_1904 {
	
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[100_001];
        dp[1] = 1;
        dp[2] = 2;
        
        for (int i = 3; i < N + 1; i++) {
			dp[i] = (dp[i - 1] % 15_746 + dp[i - 2] % 15_746) % 15_746;
		}
        
        System.out.println(dp[N]);
    }
}