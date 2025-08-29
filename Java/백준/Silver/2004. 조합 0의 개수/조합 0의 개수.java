import java.io.*;
import java.util.*;

public class Main {
    static long countP(long n, int p) {
        long cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long r = Long.parseLong(st.nextToken());

        long v2 = countP(n, 2) - countP(r, 2) - countP(n - r, 2);
        long v5 = countP(n, 5) - countP(r, 5) - countP(n - r, 5);

        System.out.println(Math.min(v2, v5));
    }
}
