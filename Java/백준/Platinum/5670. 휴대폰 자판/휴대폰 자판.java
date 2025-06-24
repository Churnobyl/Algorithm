import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        char character;
        Map<Character, Node> children = new HashMap<>();
        int size = 1;
        boolean haveLastWord;

        public Node(char character) {
            this.character = character;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "character=" + character +
                    ", size=" + size +
                    ", haveLastWord=" + haveLastWord +
                    ", children=" + children +
                    '}';
        }
    }

    static Map<Character, Node> root = new HashMap<>();
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            root.clear();
            int N = Integer.parseInt(line);

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                if (word == null) break;

                placeWord(word);
            }

            result = 0;
            findWord();
            sb.append(String.format("%.2f", result / (double)N)).append("\n");
        }

        System.out.println(sb);
    }

    private static void findWord() {
        for (Node node : root.values()) {
            dfs(node, node.size, 1);
        }
    }

    private static void dfs(Node node, int containsWord, int clicked) {
        if (node.size == 1) {
            result += clicked;
            return;
        }

        if (node.haveLastWord) {
            result += clicked;
        }

        for (Node child : node.children.values()) {
            if (child.size == containsWord) {
                dfs(child, child.size, clicked);
            } else {
                dfs(child, child.size, clicked + 1);
            }
        }
    }

    private static void placeWord(String word) {
        char[] characters = word.toCharArray();

        Node node;

        if (root.containsKey(characters[0])) {
            node = root.get(characters[0]);
            node.size++;
        } else {
            root.put(characters[0], new Node(characters[0]));
            node = root.get(characters[0]);
        }

        if (characters.length < 2) node.haveLastWord = true;

        for (int i = 1; i < characters.length; i++) {
            if (node.children.containsKey(characters[i])) {
                node = node.children.get(characters[i]);
                node.size++;
            } else {
                node.children.put(characters[i], new Node(characters[i]));
                node = node.children.get(characters[i]);
            }

            if (i == characters.length - 1) {
                node.haveLastWord = true;
            }
        }
    }
}
