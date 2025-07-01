import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[][] dp;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new int[N][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = 1;
        dp[0][1] = 1;
        answer = 1;

        for (int i = 1; i < N; i++) {
            int curr = arr[i];

            int upCache = 0;
            int downCache = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (curr > arr[j]) {
                    upCache = Math.max(dp[j][0], upCache);
                } else if (curr < arr[j]) {
                    downCache = Math.max(downCache, Math.max(dp[j][0], dp[j][1]));
                }
            }

            dp[i][0] = upCache + 1;
            dp[i][1] = downCache + 1;
            answer = Math.max(answer, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.println(answer);
    }
}
