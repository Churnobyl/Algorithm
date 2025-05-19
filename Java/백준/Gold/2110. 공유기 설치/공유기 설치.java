import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 1;
        int r = arr[N - 1] - arr[0];
        int answer = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (canPlace(mid)) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        System.out.println(answer);
    }

    private static boolean canPlace(int dist) {
        int count = 1;
        int last = arr[0];

        for (int i = 1; i < N; i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }

        return count >= C;
    }
}
