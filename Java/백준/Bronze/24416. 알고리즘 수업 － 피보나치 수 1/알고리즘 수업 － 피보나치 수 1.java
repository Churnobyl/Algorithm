import java.io.*;
import java.util.*;

public class Main {
    static int n, a;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        dp[1] = dp[2] = 1;
        A(n);
        System.out.println(a);
        System.out.println(B(n));
    }

    public static int A(int n) {
        if (n == 1 || n == 2) {
            a++;
            return 1;
        }
        return A(n - 1) + A(n - 2);
    }

    public static int B(int n) {
        return n - 2;
    }
}