package com.churnobyl.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Node2252 {
	int data;
	int incomingEdges;
	List<Integer> edges = new LinkedList<>();
	
	public Node2252(int data) {
		this.data = data;
	}
}

public class bj20240221_2252 {
	static int N, M;
	static Queue<Integer> queue = new LinkedList<>();
	static Node2252[] nodeList;
	static boolean[] visited;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        nodeList = new Node2252[N + 1];
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i < N + 1; i++) {
			nodeList[i] = new Node2252(i);
		}
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
			int front = Integer.parseInt(st.nextToken());
			int back = Integer.parseInt(st.nextToken());
			nodeList[front].edges.add(back);
			nodeList[back].incomingEdges++;
		}
        
        for (int i = 1; i < N + 1; i++) {
        	if (nodeList[i].incomingEdges == 0) {
        		visited[i] = true;
        		queue.add(i);        		
        	}
		}
        
        while (!queue.isEmpty()) {
        	int data = queue.poll();
        	sb.append(data + " ");
        	for (int edge : nodeList[data].edges) {
        		nodeList[edge].incomingEdges--;
        		
        		if (nodeList[edge].incomingEdges == 0 && !visited[edge]) {
        			queue.add(edge);
        			visited[edge] = true;
        		}
			}
        }
        
        System.out.println(sb);
    }
}