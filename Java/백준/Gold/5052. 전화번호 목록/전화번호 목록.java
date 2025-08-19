import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num, cnt;
        Node[] children = new Node[10];
        boolean isEnd;

        public Node(int num) {
            this.num = num;
        }
    }

    static int n;
    static Node root;
    static boolean flag;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            root = new Node(-1);
            flag = true;

            for (int j = 0; j < n; j++) {
                String line = br.readLine();
                noding(line);
            }
            sb.append(flag ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    private static void noding(String line) {
        Node node = root;

        for (int i = 0; i < line.length(); i++) {
            int idx = line.charAt(i) - '0';

            if (node.children[idx] == null) {
                node.children[idx] = new Node(idx);
                node.cnt++;
            } else {
                if (node.children[idx].isEnd) {
                    flag = false;
                    return;
                }

                if (i == line.length() - 1) {
                    flag = false;
                    return;
                }
            }
            node = node.children[idx];

            if (node.isEnd) {
                flag = false;
                return;
            }

            if (i == line.length() - 1) {
                node.isEnd = true;
            }
        }
    }
}
