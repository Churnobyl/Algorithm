import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (N == 1) {
            System.out.println(0);
            return;
        }

        int sum = 0;

        for (int i = N - 2; i >= 0; i--) {
            if (arr[i] >= arr[i + 1]) {
                int diff = arr[i] - arr[i + 1] + 1;
                sum += diff;
                arr[i] -= diff;
            }
        }

        System.out.println(sum);
    }
}
