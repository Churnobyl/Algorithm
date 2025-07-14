import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> cache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("-1 -1 -1")) {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append(String.format("w(%d, %d, %d) = ", a, b, c));
            int result = w(a, b, c);
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static int w(int a, int b, int c) {
        String key = makeKey(a, b, c);
        if (cache.containsKey(key)) return cache.get(key);

        int result = 0;
        if (a <= 0 || b <= 0 || c <= 0) {
            result = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
        } else if (a < b && b < c) {
            result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
        } else {
            result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
        }

        cache.put(key, result);
        return result;
    }

    private static String makeKey(int a, int b, int c) {
        return String.format("%d-%d-%d", a, b, c);
    }
}
