package com.churnobyl.bj;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class bj20240222_1793 {
	static BigInteger[] dp = new BigInteger[251];
	
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
    	dp[2] = BigInteger.valueOf(3);
        
        while (sc.hasNext()) {
        	String input = sc.nextLine();
        	
        	if (input == "") break;
        	
        	int n = Integer.parseInt(input);
        	
        	for (int i = 3; i < n + 1; i++) {
        		if (dp[i] != null) continue;
				dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
			}
        	
        	System.out.println(dp[n]);
        }
        
        sc.close();
    }
}