import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 그르다 김가놈
 * 김밥 N개의 양쪽 꼬다리를 K만큼 자르고 남은 조각을 P cm로 잘라 최소 M개를 만들기
 * 김밥의 길이가 2K가 안되면 한쪽 꼬다리만 다르고, K 이하일 경우 폐기
 * 그때 최대가 될 수 있는 P의 길이는?
 */

public class Main {
    static int N, K, M;
    static int[] gimbab;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        gimbab = new int[N];

        for (int i = 0; i < N; i++) {
            int L = Integer.parseInt(br.readLine());
            gimbab[i] = cutting(L);
        }

        run();
    }

    private static int cutting(int len) {
        if (len == 2 * K || len <= K) {
            return 0;
        } else if (len < 2 * K) {
            return len - K;
        } else {
            return len - 2 * K;
        }
    }

    private static void run() {
        int l = 1;
        int r = 1_000_000_000;

        while (l <= r) {
            int mid = (l + r) / 2;
            int n = divideGimbab(mid);

            if (n < M) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(l == 1 ? -1 : l - 1);
    }

    private static int divideGimbab(int len) {
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            cnt += gimbab[i] / len;
        }

        return cnt;
    }
}