import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
    static int[] arr;
    static int[] freq = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        long cnt = 0;
        int s = 0;

        for (int e = 0; e < N; e++) {
            while (freq[arr[e]] > 0) {
                freq[arr[s]]--;
                s++;
            }

            freq[arr[e]]++;

            cnt += e - s + 1;
        }

        System.out.println(cnt);
    }


}
