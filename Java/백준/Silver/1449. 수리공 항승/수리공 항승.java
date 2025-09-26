import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, L;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int curr = 0;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            if (curr == 0) {
                curr = arr[i];
                continue;
            }

            if (arr[i] - curr + 1 > L) {
                cnt++;
                curr = arr[i];
            }
        }

        System.out.println(cnt);
    }
}