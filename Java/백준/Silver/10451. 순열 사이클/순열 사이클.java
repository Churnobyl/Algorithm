import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j < N + 1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            boolean[] visited = new boolean[N + 1];
            int cnt = 0;

            for (int j = 1; j < N + 1; j++) {
                if (visited[j]) continue;

                int curr = j;

                while (!visited[curr]) {
                    visited[curr] = true;
                    curr = arr[curr];
                }

                if (curr == j) cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}