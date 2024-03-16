import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	char data;
	Node next, prev;
	
	public Node(char data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}

class Gear {
	Node top, rightSide, leftSide;
	Node tail;
	int count = 1;
	
	public Gear() {}
	
	public void add(Node node) {
		if (count == 1) {
			top = node;
			tail = node;
		} else if (count == 3) {
			rightSide = node;
		} else if (count == 7) {
			leftSide = node;
		}
		
		tail.next = node;
		node.prev = tail;
		tail = node;
		count++;
		
		if (count == 9) {
			tail.next = top;
			top.prev = tail;
		}
	}
	
	public void clockwise() {
		top = top.prev;
		leftSide = leftSide.prev;
		rightSide = rightSide.prev;
	}
	
	public void counterclockwise() {
		top = top.next;
		leftSide = leftSide.next;
		rightSide = rightSide.next;
	}
	
	@Override
	public String toString() {
		Node iterator = top;
		StringBuilder sb = new StringBuilder();
		sb.append(iterator.data + " ");
		iterator = iterator.next;
		while (iterator != top) {
			sb.append(iterator.data + " ");
			iterator = iterator.next;
		}
		
		return sb.toString();
	}
}

public class Main {
	static int N;
	static Gear[] gears;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		gears = new Gear[5];
		
		for (int i = 1; i < 5; i++) {
			gears[i] = new Gear();
			String line = br.readLine();
			
			for (int j = 0; j < 8; j++) {
				Node node = new Node(line.charAt(j));
				gears[i].add(node);
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken());
			int rotation = Integer.parseInt(st.nextToken());
			visited = new boolean[5];
			recursion(gearNum, rotation);
		}
		
		int total = 0;
		
		for (int i = 1; i < 5; i++) {
			if (gears[i].top.data == '1') {
				total += Math.pow(2, i - 1);
			}
		}
		System.out.println(total);
	}
	
	private static void recursion(int gearNum, int rotation) {
		if (gearNum < 1 || gearNum > 4) return;
		
		visited[gearNum] = true;
		
		Gear gear = gears[gearNum];
		
		char left = gear.leftSide.data;
		char right = gear.rightSide.data;
		
		if (rotation == 1) gear.clockwise();
		else gear.counterclockwise();
		
		// 왼쪽
		if (0 < gearNum - 1 && !visited[gearNum - 1]) {
			if (gears[gearNum - 1].rightSide.data != left) {
				recursion(gearNum - 1, -1 * rotation);
			}
		}
		
		// 오른쪽
		if (gearNum + 1 < 5 && !visited[gearNum + 1]) {
			if (gears[gearNum + 1].leftSide.data != right) {
				recursion(gearNum + 1, -1 * rotation);
			}
		}
	}
}