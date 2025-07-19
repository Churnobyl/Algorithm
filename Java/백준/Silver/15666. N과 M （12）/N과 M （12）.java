import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<Integer> list;
    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer> candidates = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        list = new ArrayList<>(set);

        dfs(0, 0);
        System.out.println(sb);
    }

    private static void dfs(int idx, int depth) {
        if (depth >= M) {
            for (int i = 0; i < candidates.size(); i++) {
                sb.append(candidates.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = idx; i < list.size(); i++) {
            candidates.add(list.get(i));
            dfs(i, depth + 1);
            candidates.removeLast();
        }
    }
}
