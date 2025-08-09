import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static Set<Character> alphabet = new HashSet<>();
    static List<Character> alphabetList;
    static String[] data;
    static int maxValue;
    static boolean[] visited;
    static Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        data = new String[N];
        visited = new boolean[10];

        for (int i = 0; i < N; i++) {
            data[i] = br.readLine();

            for (int j = 0; j < data[i].length(); j++) {
                alphabet.add(data[i].charAt(j));
            }
        }
        alphabetList = new ArrayList<>(alphabet);

        dfs(0);
        System.out.println(maxValue);
    }

    private static void dfs(int idx) {
        if (idx >= alphabetList.size()) {
            calculate();
            return;
        }

        for (int i = 9; i > 9 - alphabetList.size(); i--) {
            if (visited[i]) continue;

            map.put(alphabetList.get(idx), i);
            visited[i] = true;
            dfs(idx + 1);
            visited[i] = false;
        }
    }

    private static void calculate() {
        int result = 0;

        for (int i = 0; i < data.length; i++) {
            String d = data[i];

            int num = 0;

            for (int j = 0; j < d.length(); j++) {
                num *= 10;
                num += map.get(d.charAt(j));
            }

            result += num;
        }

        maxValue = Math.max(result, maxValue);
    }
}