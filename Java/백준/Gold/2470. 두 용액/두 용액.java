import java.io.*;
import java.util.*;

public class Main {
    static int N, left, right;
    static int[] arr;
    static int solution = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int l = 0;
        int r = N - 1;

        while (l < r) {
            int mixed = arr[l] + arr[r];

            if (Math.abs(mixed) < solution) {
                solution = Math.abs(mixed);
                left = l;
                right = r;
            }

            if (mixed > 0) {
                r--;
            } else if (mixed < 0) {
                l++;
            } else {
                break;
            }
        }

        System.out.println(arr[left] + " " + arr[right]);
    }
}
