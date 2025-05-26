import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 7; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a % 2 == 1) {
                sum += a;
                min = Math.min(min, a);
            }
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
