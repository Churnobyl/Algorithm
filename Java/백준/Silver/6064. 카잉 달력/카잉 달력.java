import java.io.*;
import java.util.*;

public class Main {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            sb.append(solve(M, N, x, y)).append("\n");
        }

        System.out.print(sb);
    }
    
    static int[] extendedGCD(int a, int b) {
        if (b == 0) return new int[]{a, 1, 0};
        int[] vals = extendedGCD(b, a % b);
        int g = vals[0];
        int x = vals[2];
        int y = vals[1] - (a / b) * vals[2];
        return new int[]{g, x, y};
    }

    static int solve(int M, int N, int x, int y) {
        int a = M;
        int b = N;
        int r = y - x;

        int[] egcd = extendedGCD(a, b);
        int g = egcd[0];
        int s = egcd[1];
        
        if (r % g != 0) return -1;
        
        int nMod = b / g;
        int t = ((r / g * s) % nMod + nMod) % nMod;
        int k = a * t + x;
        
        int lcm = a / g * b;
        if (k > lcm) return -1;

        return k;
    }
}
