import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String voca = br.readLine();
            if (voca.length() < M) continue;
            map.put(voca, map.getOrDefault(voca, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            int c1 = Integer.compare(b.getValue(), a.getValue());
            if (c1 != 0) return c1;
            int c2 = Integer.compare(b.getKey().length(), a.getKey().length());
            if (c2 != 0) return c2;
            return a.getKey().compareTo(b.getKey());
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<String, Integer> e : list) {
            sb.append(e.getKey()).append("\n");
        }

        System.out.println(sb);
    }
}