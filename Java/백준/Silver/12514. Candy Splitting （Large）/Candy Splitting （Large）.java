import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < T + 1; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] candies = new int[N];
            int xor = 0;
            int total = 0;
            int minValue = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                candies[j] = Integer.parseInt(st.nextToken());
                xor ^= candies[j];
                total += candies[j];
                minValue = Math.min(minValue, candies[j]);
            }

            if (xor == 0) {
                sb.append("Case #").append(i).append(": ").append(total - minValue).append("\n");
            } else {
                sb.append("Case #").append(i).append(": ").append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
