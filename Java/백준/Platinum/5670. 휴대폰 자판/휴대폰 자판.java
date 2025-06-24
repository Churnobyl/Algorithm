import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
        int childCount;
    }

    static Node root;
    static int totalKeyPress;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            int N = Integer.parseInt(line.trim());
            root = new Node();
            List<String> words = new ArrayList<>(N);

            for (int i = 0; i < N; i++) {
                String word = br.readLine();
                words.add(word);
                insert(word);
            }

            totalKeyPress = 0;
            for (String word : words) {
                totalKeyPress += countPress(word);
            }
            sb.append(String.format("%.2f", totalKeyPress / (double)N)).append("\n");
        }
        System.out.print(sb);
    }

    static void insert(String word) {
        Node node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Node();
                node.childCount++;
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    static int countPress(String word) {
        Node node = root;
        int press = 1;

        for (int i = 1; i < word.length(); i++) {
            int idx = word.charAt(i - 1) - 'a';
            node = node.children[idx];

            if (node.childCount > 1 || node.isEnd) {
                press++;
            }
        }
        return press;
    }
}
