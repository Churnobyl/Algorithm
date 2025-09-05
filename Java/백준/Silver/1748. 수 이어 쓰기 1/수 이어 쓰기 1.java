import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cache = N;

        int answer = 0;
        int digit = 0;
        int len = String.valueOf(N).length();

        while (cache > 0) {
            if (digit == len - 1) {
                answer += (N - ((int)Math.pow(10, len - 1) - 1)) * (digit + 1);
            } else {
                answer += 9 * (int) Math.pow(10, digit) * (digit + 1);
            }
            cache /= 10;
            digit++;
        }
        System.out.println(answer);
    }
}
