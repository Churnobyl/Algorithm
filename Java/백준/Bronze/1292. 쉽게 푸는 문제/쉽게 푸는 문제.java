import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[1001];

    public static void main(String[] args) throws IOException {
        int a = 0;

        for (int i = 1; i < 1001; i++) {
            if (a * (a + 1) / 2 < i) a++;
            arr[i] = a;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int total = 0;

        for (int i = A; i <= B; i++) {
            total += arr[i];
        }

        System.out.println(total);
    }
}
