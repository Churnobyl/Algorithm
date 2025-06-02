import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node {
        int id;
        Node parent;
        List<Node> children = new ArrayList<>();
    }

    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nodes = new Node[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int p = Integer.parseInt(st.nextToken());
            nodes[i] = new Node();
            nodes[i].id = i;
            if (p != -1) {
                nodes[p].children.add(nodes[i]);
                nodes[i].parent = nodes[p];
            }
        }

        int ans = dfs(nodes[0]);
        System.out.println(ans);
    }

    private static int dfs(Node node) {
        if (node.children.isEmpty()) {
            return 0;
        }

        List<Integer> times = new ArrayList<>();
        for (Node child : node.children) {
            times.add(dfs(child));
        }

        times.sort(Collections.reverseOrder());

        int maxTime = 0;
        for (int i = 0; i < times.size(); i++) {
            maxTime = Math.max(maxTime, times.get(i) + i + 1);
        }

        return maxTime;
    }
}
