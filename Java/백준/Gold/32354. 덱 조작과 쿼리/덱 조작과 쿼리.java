import java.io.*;
import java.util.*;

class Node {
    Node prev;
    long sum;

    Node(Node p, long s) {
        this.prev = p;
        this.sum = s;
    }
}

public class Main {
    static Node[] logs;   // logs[i] is the deck state *after* the i-th operation
    static int N, lastIndex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        logs = new Node[N + 1];  // logs[0] = null => empty deck

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();  // e.g., "Push", "POP", etc.

            switch (cmd) {
                case "push":  // or "Push"
                {
                    long x = Long.parseLong(st.nextToken());
                    long newSum = (logs[lastIndex] != null ? logs[lastIndex].sum : 0) + x;
                    logs[i] = new Node(logs[lastIndex], newSum);
                    lastIndex = i;
                    break;
                }
                case "pop":   // or "POP"
                {
                    if (logs[lastIndex] != null) {
                        logs[i] = logs[lastIndex].prev;  // revert
                    } else {
                        logs[i] = null;  // deck was already empty
                    }
                    lastIndex = i;
                    break;
                }
                case "restore":  // or "RESTORE"
                {
                    int k = Integer.parseInt(st.nextToken());
                    logs[i] = logs[k];  // might be null if k=0
                    lastIndex = i;
                    break;
                }
                case "print":
                {
                    long ans = (logs[lastIndex] != null ? logs[lastIndex].sum : 0);
                    sb.append(ans).append("\n");
                    // Keep the same state for the i-th op
                    logs[i] = logs[lastIndex];
                    lastIndex = i;
                    break;
                }
            }
        }

        System.out.print(sb);
    }
}
