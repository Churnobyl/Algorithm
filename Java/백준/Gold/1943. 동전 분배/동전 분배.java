import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());

            List<Integer> items = new ArrayList<>();
            int sum = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                sum += value * num;

                int power = 1;
                while (num > 0) {
                    int take = Math.min(power, num);
                    items.add(value * take);
                    num -= take;
                    power <<= 1;
                }
            }

            if (sum % 2 == 1) {
                sb.append("0\n");
                continue;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int item : items) {
                for (int j = target; j >= item; j--) {
                    if (dp[j - item]) {
                        dp[j] = true;
                    }
                }
            }

            sb.append(dp[target] ? "1\n" : "0\n");
        }

        System.out.print(sb);
    }
}