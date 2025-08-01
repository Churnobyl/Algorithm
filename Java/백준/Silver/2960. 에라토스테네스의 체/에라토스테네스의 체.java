import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];

        int cnt = 0;

        for (int i = 2; i < N + 1; i++) {
            if (arr[i]) continue;

            for (int j = i; j < N + 1; j += i) {
                if (!arr[j]) {
                    arr[j] = true;
                    cnt++;

                    if (cnt == K) {
                        System.out.println(j);
                        return;
                    }
                }
            }
        }
    }
}