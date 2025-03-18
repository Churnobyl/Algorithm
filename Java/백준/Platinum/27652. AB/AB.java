import java.io.*;
import java.util.*;

class Node {
    int count;
    Node[] alphabet = new Node[26];

    public Node() {
    }

    @Override
    public String toString() {
        return "Node{" +
                "count=" + count
                + "}";
    }
}

public class Main {
    static Node A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = new Node();
        B = new Node();

        int Q = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String query = st.nextToken();

            switch (query) {
                case "add":
                    add(st.nextToken(), st.nextToken());
                    break;
                case "delete":
                    delete(st.nextToken(), st.nextToken());
                    break;
                case "find":
                    sb.append(find(st.nextToken())).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    private static int find(String data) {
        int sum = 0;

        for (int i = 1; i < data.length(); i++) {
            sum += query(A, data.substring(0, i)) * query(B, data.substring(i));
        }

        return sum;
    }

    private static int query(Node set, String substring) {
        if (set == A) {
            for (int i = 0; i < substring.length(); i++) {
                set = set.alphabet[substring.charAt(i) - 'a'];

                if (set == null) {
                    return 0;
                }
            }
        } else {
            for (int i = substring.length() - 1; i >= 0; i--) {
                set = set.alphabet[substring.charAt(i) - 'a'];

                if (set == null) {
                    return 0;
                }
            }
        }

        return set.count;
    }

    public static void delete(String set, String data) {
        if (set.equals("A")) {
            deleteRecursive(A, A, data, 0);
        } else {
            deleteRecursive(B, B, data, data.length() - 1);
        }
    }

    private static void deleteRecursive(Node set, Node root, String data, int index) {
        if (root == A && index == data.length()) return;
        if (root == B && index == -1) return;

        int charIndex = data.charAt(index) - 'a';

        if (set.alphabet[charIndex].count > 0) {
            set.alphabet[charIndex].count--;
        } else {
            return;
        }

        if (root == A) {
            deleteRecursive(set.alphabet[charIndex], root, data, index + 1);
        } else {
            deleteRecursive(set.alphabet[charIndex], root, data, index - 1);
        }

    }

    public static void add(String set, String data) {
        if (set.equals("A")) {
            addRecursive(A, A, data, 0);
        } else {
            addRecursive(B, B, data, data.length() - 1);
        }
    }

    private static void addRecursive(Node set, Node root, String data, int index) {
        if (root == A && index == data.length()) return;
        if (root == B && index == -1) return;

        int charIndex = data.charAt(index) - 'a';

        if (set.alphabet[charIndex] == null) {
            set.alphabet[charIndex] = new Node();
        }

        set.alphabet[charIndex].count++;

        if (root == A) {
            addRecursive(set.alphabet[charIndex], root, data, index + 1);
        } else {
            addRecursive(set.alphabet[charIndex], root, data, index - 1);
        }
    }
}
