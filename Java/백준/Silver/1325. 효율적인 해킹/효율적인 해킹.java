import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer>[] rev;
    static int[] visited;
    static int stamp = 1;
    static int[] reachCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        rev = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) rev[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            rev[B].add(A);
        }

        visited = new int[N + 1];
        reachCnt = new int[N + 1];

        int maxReach = 0;
        for (int i = 1; i <= N; i++) {
            int cnt = bfs(i);
            reachCnt[i] = cnt;
            if (cnt > maxReach) maxReach = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (reachCnt[i] == maxReach) {
                sb.append(i).append(' ');
            }
        }
        System.out.print(sb.toString().trim());
    }

    static int bfs(int start) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        visited[start] = ++stamp;
        q.add(start);
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : rev[cur]) {
                if (visited[nxt] != stamp) {
                    visited[nxt] = stamp;
                    q.add(nxt);
                    count++;
                }
            }
        }
        return count;
    }
}
