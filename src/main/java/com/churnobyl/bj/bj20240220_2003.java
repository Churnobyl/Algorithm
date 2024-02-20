package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전략 : 슬라이딩 윈도우
 * 연속적인 수들의 합이 M이 되는 경우의 수를 구하는 것이므로
 * 처음에는 M이 될 때까지 숫자를 더하다가 M을 넘었다면 앞에 있는 수부터 차례로 뺀다.
 * 뺀 수로 인해 수들의 합이 M이 되었다면 count + 1해주고, 아니라면 다시 다음 수를 더한다.
 */

public class bj20240220_2003 {
	static int N, M;
	static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        A = new int[N];
        
        int total = 0;
        int head = 0;
        int count = 0;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
        
        for (int i = 0; i < N; i++) {
			total += A[i];
			
			while (total > M) {
				total -= A[head];
				head++;
			}
			
			if (total == M) count++;
		}
        
        System.out.println(count);
    }
}