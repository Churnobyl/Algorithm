import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static Set<String> set = new TreeSet<>();
    static int[] cacheArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        cacheArr = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(-1, 0);

        System.out.println(sb);
    }

    private static void dfs(int idx, int depth) {
        if (depth >= M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb2.append(cacheArr[i]).append(" ");
            }
            if (!set.contains(sb2.toString())) {
                set.add(sb2.toString());
                sb.append(sb2).append("\n");
            }
            return;
        }

        for (int i = idx + 1; i < N; i++) {
            cacheArr[depth] = arr[i];
            dfs(i, depth + 1);
        }
    }
}
