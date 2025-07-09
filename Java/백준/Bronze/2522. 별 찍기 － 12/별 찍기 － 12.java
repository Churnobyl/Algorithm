import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(1);
        System.out.println(sb);
    }

    private static void dfs(int depth) {
        if (depth == N + 1) return;

        sb.append(String.format("%" + N + "s", "*".repeat(depth))).append("\n");
        dfs(depth + 1);
        if (depth != N) sb.append(String.format("%" + N + "s", "*".repeat(depth))).append("\n");
    }
}
