import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int data;
        Node l, r;
    }

    static int N;
    static int[] preOrder, inOrder;
    static int index;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            preOrder = new int[N];
            inOrder = new int[N];
            index = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                preOrder[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                inOrder[j] = Integer.parseInt(st.nextToken());
            }

            root = new Node();
            recursion(root, 0, N - 1);

            find(root);
            System.out.println("");
        }
    }

    private static void find(Node node) {
        if (node.l != null) find(node.l);
        if (node.r != null) find(node.r);
        System.out.print(node.data + " ");
    }

    private static void recursion(Node node, int s, int e) {
        if (index >= N) return;
        if (s == e) {
            node.data = preOrder[index];
            index++;
            return;
        }

        int inOrderIndex = -1;

        for (int i = s; i <= e; i++) {
            if (preOrder[index] == inOrder[i]) {
                inOrderIndex = i;
                break;
            }
        }

        node.data = preOrder[index];
        index++;

        if (s < inOrderIndex) {
            node.l = new Node();
            recursion(node.l, s, inOrderIndex - 1);
        }

        if (inOrderIndex < e) {
            node.r = new Node();
            recursion(node.r, inOrderIndex + 1, e);
        }
    }
}
