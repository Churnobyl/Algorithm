package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class bj20240220_7662 {
	static int N;
    static PriorityQueue<Integer> minHeap, maxHeap;
    static Map<Integer, Integer> countMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            setting(br);
            run(br);         
        }
    }

    private static void setting(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        countMap = new HashMap<>();
    }

    private static void run(BufferedReader br) throws IOException {
        
        for (int i = 0; i < N; i++) {
            String[] data = br.readLine().split(" ");
            
            if (data[0].equals("I")) {
                input(Integer.parseInt(data[1]));
            }
            
            if (data[0].equals("D")) {
                delete(Integer.parseInt(data[1]));
            }
        }
        
        while (!maxHeap.isEmpty() && countMap.getOrDefault(maxHeap.peek(), 0) == 0) {
            maxHeap.poll();
        }
        while (!minHeap.isEmpty() && countMap.getOrDefault(minHeap.peek(), 0) == 0) {
            minHeap.poll();
        }

        if (maxHeap.isEmpty() || minHeap.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            System.out.printf("%d %d\n", maxHeap.peek(), minHeap.peek());
        }
    }

    private static void input(int data) {
        maxHeap.add(data);
        minHeap.add(data);
        countMap.put(data, countMap.getOrDefault(data, 0) + 1);
    }

    private static void delete(int type) {
        if (type == 1) {
            remove(maxHeap);
        } else {
            remove(minHeap);
        }
    }

    private static void remove(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (countMap.getOrDefault(num, 0) > 0) {
                countMap.put(num, countMap.get(num) - 1);
                heap.poll();
                break;
            } else {
                heap.poll();
            }
        }
    }
}