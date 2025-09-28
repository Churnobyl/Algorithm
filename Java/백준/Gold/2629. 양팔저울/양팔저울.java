import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] weights;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        int total = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            total += weights[i];
        }

        boolean[] dp = new boolean[total + 1];
        dp[0] = true;

        for (int i = 0; i < N; i++) {
            int weight = weights[i];
            for (int j = total; j >= weight; j--) {
                if (dp[j - weight]) {
                    dp[j] = true;
                }
            }
        }

        boolean[] measurable = new boolean[total + 1];
        for (int left = 0; left <= total; left++) {
            if (dp[left]) {
                for (int right = 0; right <= total; right++) {
                    if (dp[right]) {
                        int diff = Math.abs(left - right);
                        if (diff <= total) {
                            measurable[diff] = true;
                        }
                    }
                }
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int marble = Integer.parseInt(st.nextToken());

            if (marble <= total && measurable[marble]) {
                result.append("Y");
            } else {
                result.append("N");
            }

            if (i < M - 1) {
                result.append(" ");
            }
        }

        System.out.println(result);
    }
}