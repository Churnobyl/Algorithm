import java.io.*;
import java.util.*;

public class Main {
    static int N, T, P;
    static int[] size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        size = new int[6];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int res = 0;

        for (int i = 0; i < 6; i++) {
            res += (int) Math.ceil(size[i] / (double)T);
        }
        System.out.println(res);

        System.out.print(N / P);
        System.out.print(" ");
        System.out.print(N % P);
    }
}
