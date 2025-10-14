import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int prev = Integer.parseInt(st.nextToken());
            for (int j = 1; j < cnt; j++) {
                int next = Integer.parseInt(st.nextToken());
                graph.get(prev).add(next);
                inDegree[next]++;
                prev = next;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) q.add(i);
        }

        List<Integer> result = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            result.add(cur);
            for (int next : graph.get(cur)) {
                inDegree[next]--;
                if (inDegree[next] == 0) q.add(next);
            }
        }

        if (result.size() != N) {
            System.out.println(0);
        } else {
            for (int num : result) {
                System.out.println(num);
            }
        }
    }
}
