package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 전략 : 슬라이딩 윈도우
 * 연속적인 수들의 합이 S 이상이 되는 수들 중 가장 짧은 길이를 구하는 것으로
 * 처음에는 S 이상이 될 때까지 숫자를 더하다가 S을 넘었다면 앞에 있는 수부터 차례로 뺀다.
 * 차례로 뺄 때마다 길이를 업데이트하다가 S 이하가 되었다면 다시 숫자들을 더하기 시작한다.
 */

public class bj20240220_1806 {
	static int N, S;
	static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        
        arr = new int[N];
        
        int total = 0;
        int head = 0;
        int tail = 0;
        int length = Integer.MAX_VALUE;
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
        
        while (tail < N) {
        	total += arr[tail];
        	tail++;
        	
        	if (total < S) continue;
        	
        	while (total >= S) {
        		total -= arr[head];
        		head++;
        		length = Math.min(length, tail - head + 1);
        	}
        }
        
        if (length == Integer.MAX_VALUE) {
        	System.out.println(0);
        } else {
        	System.out.println(length);
        }
    }
}