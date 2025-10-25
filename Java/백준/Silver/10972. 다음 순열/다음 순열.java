import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        if (nextPermutation(arr)) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean nextPermutation(int[] arr) {
        int i = N - 1;

        while (i > 0 && arr[i - 1] >= arr[i]) i--;
        if (i == 0) return false;

        int j = N - 1;
        while (arr[i - 1] >= arr[j]) j--;

        swap(arr, i - 1, j);

        int t = N - 1;

        while (i < t) swap(arr, i++, t--);

        return true;
    }

    public static void swap(int[] arr, int a, int b) {
        int cache = arr[a];
        arr[a] = arr[b];
        arr[b] = cache;
    }
}