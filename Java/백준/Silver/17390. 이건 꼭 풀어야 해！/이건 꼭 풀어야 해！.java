import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Integer[] arr = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(prefixSum[e] - prefixSum[s - 1]).append("\n");
        }

        System.out.print(sb);
    }
}
