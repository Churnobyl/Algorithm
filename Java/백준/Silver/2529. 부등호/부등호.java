import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static char[] sign;
    static boolean[] used = new boolean[10];

    static boolean ok(char s, int a, int b) {
        return s == '<' ? a < b : a > b;
    }
    
    static String firstByOrder(int[] order) {
        Arrays.fill(used, false);
        StringBuilder sb = new StringBuilder();
        if (dfs(0, sb, order)) return sb.toString();
        return null;
    }

    static boolean dfs(int pos, StringBuilder sb, int[] order) {
        if (pos == k + 1) return true;

        for (int d : order) {
            if (used[d]) continue;
            if (pos == 0 || ok(sign[pos - 1], sb.charAt(pos - 1) - '0', d)) {
                used[d] = true;
                sb.append(d);
                if (dfs(pos + 1, sb, order)) return true;
                sb.deleteCharAt(sb.length() - 1);
                used[d] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine().trim());

        sign = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) sign[i] = st.nextToken().charAt(0);

        int[] asc  = new int[10]; // 0..9
        int[] desc = new int[10]; // 9..0
        for (int i = 0; i < 10; i++) {
            asc[i] = i;
            desc[i] = 9 - i;
        }

        String max = firstByOrder(desc);
        String min = firstByOrder(asc);

        System.out.println(max);
        System.out.println(min);
    }
}
