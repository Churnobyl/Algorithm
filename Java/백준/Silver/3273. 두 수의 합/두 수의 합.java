import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, x;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int l = 0, r = n - 1, result = 0;

        while (l < r) {
            int a = arr[l] + arr[r];

            if (a < x) {
                l++;
            } else if (a == x) {
                result++;
                l++;
                r--;
            } else {
                r--;
            }
        }

        System.out.println(result);
    }
}
