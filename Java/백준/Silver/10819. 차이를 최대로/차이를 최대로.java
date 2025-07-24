import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int answer;
    static int cache;
    static int[] cacheList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        cacheList = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            answer = Math.max(answer, cache);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cacheList[depth] = arr[i];
                if (depth > 0) {
                    cache += Math.abs(cacheList[depth] - cacheList[depth - 1]);
                }

                dfs(depth + 1);

                visited[i] = false;
                if (depth > 0) {
                    cache -= Math.abs(cacheList[depth] - cacheList[depth - 1]);
                }
            }
        }
    }
}
