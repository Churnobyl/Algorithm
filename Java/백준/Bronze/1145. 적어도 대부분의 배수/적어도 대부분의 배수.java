import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[5];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    int lcm = getLcm(getLcm(arr[i], arr[j]), arr[k]);
                    int count = 0;
                    for (int x : arr) {
                        if (lcm % x == 0) count++;
                    }
                    if (count >= 3) {
                        answer = Math.min(answer, lcm);
                    }
                }
            }
        }

        System.out.println(answer);
    }

    private static int getGcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int getLcm(int a, int b) {
        return a * b / getGcd(a, b);
    }
}
