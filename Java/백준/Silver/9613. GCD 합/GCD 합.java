import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];

            long sum = 0;

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());

                for (int k = 0; k < j; k++) {
                    sum += gcd(arr[k], arr[j]);
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
    }

    private static Integer gcd(int a, int b) {
        if (a < b) {
            int cache = a;
            a = b;
            b = cache;
        }

        while (b > 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }

        return a;
    }
}
