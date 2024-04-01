import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static List<int[]>[] edges;
	static int[] degree;
	static Map<Integer, Integer> bases = new HashMap<>();
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		degree = new int[N + 1];
		edges = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			edges[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int complete = Integer.parseInt(st.nextToken());
			int intermediate = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			edges[complete].add(new int[] { intermediate, num });
			degree[intermediate]++;
		}

		queue.add(new int[] { N, 1 });

		while (!queue.isEmpty()) {
//			for (int i = 0; i < queue.size(); i++) {
//				System.out.print(((int[])queue.toArray()[i])[0] + " " + ((int[])queue.toArray()[i])[1]);
//				System.out.print(", ");
//			}
//			System.out.println();
//
//			System.out.println(bases);

			int[] next = queue.poll();
			int part = next[0];
			int num = next[1];

			if (edges[part].size() == 0) {
				bases.put(part, bases.getOrDefault(part, 0) + num);
				continue;
			}

			for (int[] e : edges[part]) {
				degree[e[0]]--;
				if (degree[e[0]] == 0) {
					queue.add(new int[] { e[0], bases.getOrDefault(e[0], 0) + num * e[1] });
					bases.remove(e[0]);
				} else {
					bases.put(e[0], bases.getOrDefault(e[0], 0) + num * e[1]);
				}
			}
		}

		List<Map.Entry<Integer, Integer>> result = new ArrayList<>(bases.entrySet());
		Collections.sort(result, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return Integer.compare(o1.getKey(), o2.getKey());
			}
		});

		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).getKey() + " " + result.get(i).getValue());
		}
	}
}
