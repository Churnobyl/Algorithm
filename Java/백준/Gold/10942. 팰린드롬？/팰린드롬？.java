import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static Boolean[][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        memo = new Boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken()) - 1;
            int E = Integer.parseInt(st.nextToken()) - 1;
            sb.append(isPalindrome(S, E) ? 1 : 0).append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isPalindrome(int S, int E) {
        if (memo[S][E] != null) {
            return memo[S][E];
        }
        
        if (S >= E) {
            return memo[S][E] = true;
        }

        if (arr[S] != arr[E]) {
            return memo[S][E] = false;
        }
        
        return memo[S][E] = isPalindrome(S + 1, E - 1);
    }
}