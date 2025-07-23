import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static long N, P, Q, X, Y;
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        System.out.println(dfs(N));
    }

    private static long dfs(long i) {
        if (i <= 0) return 1;
        if (map.containsKey(i)) return map.get(i);
        long result = dfs(i / P - X) + dfs(i / Q - Y);
        map.putIfAbsent(i, result);
        return result;
    }
}
