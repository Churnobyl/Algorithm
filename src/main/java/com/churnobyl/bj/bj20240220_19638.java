package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj20240220_19638 {
    static int N, H, T;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < N; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data >= H) pq.add(data);
        }
        
        int count = 0;
        
        while (!pq.isEmpty() && T > 0 && pq.peek() >= H) {
            int giant = pq.poll();
            
            if (giant != 1) giant /= 2;
            T--;
            count++;
            
            if (giant >= H) {
                pq.add(giant);
            }
        }
        
        if (pq.isEmpty() || pq.peek() < H) {
            System.out.println("YES");
            System.out.println(count);				
        } else {
            System.out.println("NO");
            System.out.println(pq.poll());				
        }
    }
}