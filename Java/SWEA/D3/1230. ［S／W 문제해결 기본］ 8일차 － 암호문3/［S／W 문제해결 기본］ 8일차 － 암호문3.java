import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

class SinglyLinkedList {
	Node head, tail;

	public SinglyLinkedList() {
	}

	public void addLast(int num) {
		Node newNode = new Node(num);

		if (this.tail == null) {
			head = newNode;
			tail = newNode;
			return;
		}

		this.tail.next = newNode;
		this.tail = newNode;
	}

	public void insert(int idx, SinglyLinkedList merged) {
		Node target = findNode(idx);

		merged.tail.next = target.next;
		target.next = merged.head;
	}

	private Node findNode(int x) {
		Node iterator = head;

		int idx = 0;

		while (idx < x) {
			iterator = iterator.next;
			idx++;
		}

		return iterator;
	}
	
	public void delete(int idx, int count) {
		Node e = findNode(idx + count);
		
		if (idx == 0) {
			this.head = e;
			return;
		}
		
		Node s = findNode(idx);
		
		if (e != null) {
			s.next = e.next;			
		} else {
			s.next = null;
			this.tail = s;
		}
	}
	
	public String toString(boolean isLast) {
		StringBuilder sb = new StringBuilder();
		
		Node iterator = head.next;
		
		int count = 0;
		
		while (iterator != null) {
			sb.append(iterator.data).append(" ");
			iterator = iterator.next;
			count++;
			
			if (isLast && count == 10) {
				break;
			}
		}
		
		return sb.toString();
	}
}

public class Solution {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 11; i++) {
			sb.append("#" + i + " ");
			N = Integer.parseInt(br.readLine());
			SinglyLinkedList mainLL = new SinglyLinkedList();
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				mainLL.addLast(Integer.parseInt(st.nextToken()));
			}
			
			M = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < M; j++) {
				String command = st.nextToken();
				
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					SinglyLinkedList subLL = new SinglyLinkedList();
					
					for (int k = 0; k < y; k++) {
						subLL.addLast(Integer.parseInt(st.nextToken()));
					}
					
					mainLL.insert(x, subLL);

				} else if (command.equals("A")) {
					int c = Integer.parseInt(st.nextToken());
					
					for (int k = 0; k < c; k++) {
						mainLL.addLast(Integer.parseInt(st.nextToken()));
					}
					
				} else if (command.equals("D")) {
					int s = Integer.parseInt(st.nextToken());
					int e = Integer.parseInt(st.nextToken());
					
					mainLL.delete(s, e);
				}
			}
			
			sb.append(mainLL.toString(true)).append("\n");
		}
		
		System.out.println(sb);
	}
}
