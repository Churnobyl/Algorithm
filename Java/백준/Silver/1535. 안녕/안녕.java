import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] loss, joy;
    static int[] dp; // 1차원 DP 배열 사용

    public static void main(String[] args) throws IOException {
        setting();
        solve();
        System.out.println(findMaxJoy());
    }

    private static void setting() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        loss = new int[N];
        joy = new int[N];
        dp = new int[101]; // 체력 100까지 사용 가능

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            loss[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            joy[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static void solve() {
        for (int i = 0; i < N; i++) { // 각 사람에 대해
            for (int h = 99; h >= loss[i]; h--) { // 뒤에서 앞으로 갱신 (중복 사용 방지)
                dp[h] = Math.max(dp[h], dp[h - loss[i]] + joy[i]);
            }
        }
    }

    private static int findMaxJoy() {
        int maxJoy = 0;
        for (int h = 1; h <= 100; h++) {
            maxJoy = Math.max(maxJoy, dp[h]);
        }
        return maxJoy;
    }
}
