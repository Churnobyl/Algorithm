import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr, seq;
    static boolean[] visited;
    static Set<String> result = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        seq = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        dfs(0);

        for (String s : result) System.out.println(s);
    }

    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(seq[i]);
                if (i != M - 1) sb.append(' ');
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                seq[depth] = arr[i];
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
