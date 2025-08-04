import java.io.*;
import java.util.*;

public class Main {
    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int maxYear = lcm(M, N);
            boolean found = false;

            for (int k = x; k <= maxYear; k += M) {
                if ((k % N == y % N)) {
                    sb.append(k).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) sb.append(-1).append("\n");
        }

        System.out.print(sb);
    }
}
