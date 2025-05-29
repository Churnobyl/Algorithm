import java.io.*;
import java.util.*;

public class Main {
    static class Wire implements Comparable<Wire> {
        int a, b;
        public Wire(int a, int b) { this.a = a; this.b = b; }
        public int compareTo(Wire o) { return this.a - o.a; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Wire[] arr = new Wire[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);

        int[] dp = new int[n];          // 실제 LIS 값
        int[] idx = new int[n];         // 인덱스
        int[] prev = new int[n];        // LIS 경로 추적용

        Arrays.fill(prev, -1);
        int len = 0;

        int[] lisIdx = new int[n];      // LIS를 만드는 인덱스

        for (int i = 0; i < n; i++) {
            int b = arr[i].b;
            int pos = Arrays.binarySearch(dp, 0, len, b);
            if (pos < 0) pos = -(pos + 1);
            dp[pos] = b;
            idx[pos] = i;
            if (pos > 0) prev[i] = idx[pos - 1];
            if (pos == len) len++;
        }

        // LIS에 포함된 index 추적
        boolean[] inLis = new boolean[n];
        int k = idx[len - 1];
        for (int i = len - 1; i >= 0; i--) {
            inLis[k] = true;
            k = prev[k];
        }

        ArrayList<Integer> toRemove = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!inLis[i]) toRemove.add(arr[i].a);
        }
        Collections.sort(toRemove);

        System.out.println(toRemove.size());
        for (int a : toRemove) System.out.println(a);
    }
}
