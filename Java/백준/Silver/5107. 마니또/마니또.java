import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static Map<String, String> nextManitou = new HashMap<>();
    static Set<String> visited;
    static Set<String> finished;
    static int cycleCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            nextManitou.clear();
            visited = new HashSet<>();
            finished = new HashSet<>();
            cycleCount = 0;

            for (int i = 0; i < N; i++) {
                String[] relation = br.readLine().split(" ");
                nextManitou.put(relation[0], relation[1]);
            }

            for (String person : nextManitou.keySet()) {
                if (!visited.contains(person)) {
                    dfs(person);
                }
            }

            sb.append(testCase++).append(" ").append(cycleCount).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(String current) {
        visited.add(current);
        String next = nextManitou.get(current);

        if (next != null) {
            if (!visited.contains(next)) {
                dfs(next);
            } else if (!finished.contains(next)) {
                cycleCount++; // 사이클 발견
            }
        }

        finished.add(current);
    }
}
