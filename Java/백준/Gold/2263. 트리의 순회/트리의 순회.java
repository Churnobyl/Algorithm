import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int data;
	Node left, right;
	public Node(int data) {
		this.data = data;
	}
}

public class Main {
	static int n;
	static int[] inorderArr;
	static int[] postorderArr;
	static Node root;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());

		inorderArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		postorderArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
				
		recursion(0, inorderArr.length - 1, 0, postorderArr.length - 1, 0);
		inorder(root);
		System.out.println(sb);
	}
	
	public static Node recursion(int is, int ie, int ps, int pe, int depth) {
		Node parent = new Node(postorderArr[pe]);
		
		if (is == ie) {
			return parent;
		}
		
		if (depth == 0) root = parent;
		
		int inmid = -1;
		
		for (int i = is; i < ie + 1; i++) {
			if (inorderArr[i] == postorderArr[pe]) {
				inmid = i;
				break;
			}
		}
		
		if (is < inmid) {
			parent.left = recursion(is, inmid - 1, ps, ps - 1 + (inmid - is), depth + 1);			
		}
		
		if (inmid < ie) {
			parent.right = recursion(inmid + 1, ie, ps + (inmid - is), pe - 1, depth + 1);			
		}
		
		return parent;
	}
	
	private static void inorder(Node node) {
		if (node == null) return;
		
		sb.append(node.data + " ");
		inorder(node.left);
		inorder(node.right);
	}
}