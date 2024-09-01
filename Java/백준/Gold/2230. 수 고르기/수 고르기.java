import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = Integer.MAX_VALUE;

        int l = 0, r = 1;

        while (r < N) {
            int diff = arr[r] - arr[l];

            if (diff >= M) {
                result = Math.min(result, diff);
                l++;
            } else {
                r++;
            }

            if (l == r) {
                r++;
            }
        }

        System.out.println(result);
    }
}
