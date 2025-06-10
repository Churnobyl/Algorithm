import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        TreeMap<String, Node> children = new TreeMap<>();

        public Node() {
        }

        public Node(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return name.compareTo(o.name);
        }
    }

    static int N;
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            Node curr = root;

            for (int j = 0; j < cnt; j++) {
                String next = st.nextToken();

                if (!curr.children.containsKey(next)) {
                    Node newNode = new Node(next);
                    curr.children.put(next, newNode);
                    curr = newNode;
                } else {
                    curr = curr.children.get(next);
                }
            }
        }

        dfs(root, 0);
        System.out.println(sb);
    }

    private static void dfs(Node node, int depth) {
        if (node.children.isEmpty()) return;

        for (Map.Entry<String, Node> entry : node.children.entrySet()) {
            String key = entry.getKey();
            Node value = entry.getValue();

            sb.append("-".repeat(depth * 2)).append(key).append("\n");
            dfs(value, depth + 1);
        }
    }
}
