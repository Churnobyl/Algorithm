import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int F, index;
    static int[] p;
    static int[] friends;
    static Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            map.clear();
            F = Integer.parseInt(br.readLine());
            index = 0;
            p = new int[2 * F + 1];
            friends = new int[2 * F + 1];

            for (int j = 0; j < 2 * F + 1; j++) {
                p[j] = j;
                friends[j] = 1;
            }


            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String f1 = st.nextToken();
                String f2 = st.nextToken();

                if (!map.containsKey(f1)) {
                    map.put(f1, index++);
                }

                if (!map.containsKey(f2)) {
                    map.put(f2, index++);
                }

                union(map.get(f1), map.get(f2));
                int result = friends[Math.min(p[map.get(f1)], p[map.get(f2)])];
                sb.append(result).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }

    private static boolean union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return false;

        p[Math.max(x, y)] = Math.min(x, y);
        friends[Math.min(x, y)] += friends[Math.max(x, y)];
        return true;
    }
}
