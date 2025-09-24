import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            int[] result = getReducedFraction(arr[0], arr[i]);
            sb.append(result[0]).append("/").append(result[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] getReducedFraction(int a, int b) {
        int gcd = getGcd(a, b);
        return new int[] {a / gcd, b / gcd};
    }

    private static int getGcd(int a, int b) {
        if (a < b) {
            int cache = a;
            a = b;
            b = cache;
        }

        while (b > 0) {
            int t = a % b;
            a = b;
            b = t;
        }

        return a;
    }
}