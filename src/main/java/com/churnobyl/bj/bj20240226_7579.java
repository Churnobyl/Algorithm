package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj20240226_7579 {
    static int N, M;
    static int[] memory;
    static int[] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        memory = new int[N];
        cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int sumCost = 0;
        for (int c : cost) {
            sumCost += c;
        }

        dp = new int[N + 1][sumCost + 1];
        for (int i = 1; i <= N; i++) {
            int curMem = memory[i - 1];
            int curCost = cost[i - 1];
            for (int j = 0; j <= sumCost; j++) {
                if (j >= curCost) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curCost] + curMem);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i <= sumCost; i++) {
            if (dp[N][i] >= M) {
                minCost = Math.min(minCost, i);
                break;
            }
        }

        System.out.println(minCost);
    }
}