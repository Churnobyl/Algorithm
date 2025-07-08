import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char alphabet;
        Node[] children = new Node[26];

        public Node(char alphabet) {
            this.alphabet = alphabet;
        }
    }

    static int N;
    static Node root = new Node('-');
    static StringBuilder sb = new StringBuilder();
    static Map<String, Integer> nicknameCache = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String username = br.readLine();
            makeNickname(username);
        }

        System.out.println(sb);
    }

    private static void makeNickname(String username) {
        Node node = root;
        boolean made = false;

        for (int i = 0; i < username.length(); i++) {
            char next = username.charAt(i);

            if (node.children[next - 'a'] == null) {
                node.children[next - 'a'] = new Node(next);

                if (!made) {
                    made = true;
                    sb.append(username.substring(0, i + 1)).append("\n");
                }
            }

            node = node.children[next - 'a'];
        }

        if (!made) {
            if (!nicknameCache.containsKey(username)) {
                sb.append(username).append("\n");
            } else {
                sb.append(username + (nicknameCache.get(username) + 1)).append("\n");
            }
        }

        nicknameCache.put(username, nicknameCache.getOrDefault(username, 0) + 1);
    }
}
