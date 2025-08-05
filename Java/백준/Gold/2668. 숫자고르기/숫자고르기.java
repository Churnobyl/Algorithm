import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1]; // 1-indexed
        visited = new boolean[n + 1];
        finished = new boolean[n + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, new ArrayList<>());
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int current, List<Integer> path) {
        if (finished[current]) {
            return;
        }

        if (visited[current]) {
            int idx = path.indexOf(current);
            for (int i = idx; i < path.size(); i++) {
                result.add(path.get(i));
                finished[path.get(i)] = true;
            }
            return;
        }

        visited[current] = true;
        path.add(current);

        dfs(arr[current], path);

        path.remove(path.size() - 1);
        finished[current] = true;
    }
}