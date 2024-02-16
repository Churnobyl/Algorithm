package com.churnobyl.bj;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

class Node {
	int data;
	Node left, right;
	
	public Node(String data) {
		this.data = Integer.parseInt(data);
	}
}

class Tree {
	
}

public class bj20240216_5639 {
	static String data;
	static Node root;
	static Stack<Node> stack = new Stack<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNextLine()) {
			data = sc.nextLine();
			
			if (data.equals("")) break;
			
			Node node = new Node(data);
			
			if (stack.isEmpty() || root == null) {
				root = node;
				stack.push(node);
				continue;
			}
			
			if (stack.peek().data > node.data) {
				stack.peek().left = node;
				stack.push(node);
			} else {
				Node cache = null;
				
				while (!stack.isEmpty() && stack.peek().data < node.data) {
					cache = stack.pop();
				}
				
				cache.right = node;
				stack.push(node);
			}
		}
		
		postorder(root);
		sc.close();
	}
	
	private static void postorder(Node node) {
		if (node == null) return;
		
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
}