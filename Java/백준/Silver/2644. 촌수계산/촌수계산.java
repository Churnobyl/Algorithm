import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
	int data, depth;
	Node parent;
	List<Node> children = new LinkedList<>();
	
	public Node(int data) {
		this.data = data;
	}
}

public class Main {
	static int n, A, B, m;
	static Node[] tree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		tree = new Node[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			tree[i] = new Node(i);
		}
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			
			tree[parent].children.add(tree[child]);
			tree[child].parent = tree[parent];
			tree[child].depth = findDepth(tree[child]);
		}
		
		Node a = tree[A];
		Node b = tree[B];
		
		int count = 0;
		
		if (a.depth > b.depth) {
			while (a.depth != b.depth) {
				a = a.parent;
				count++;
			}
		} else if (a.depth < b.depth) {
			while (a.depth != b.depth) {
				b = b.parent;
				count++;
			}
		}
		
		while (a != null || a != b) {
			if (a != null && a == b) {
				break;
			}
			
			a = a.parent;
			b = b.parent;
			count += 2;
		}
		
		if (a == null) {
			System.out.println(-1);
		} else {
			System.out.println(count);
		}
	}
	
	private static int findDepth(Node node) {
		int count = 0;
		
		while (node.parent != null) {
			count++;
			node = node.parent;
		}
		
		return count;
	}
}