import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 1_000_001;
    static boolean[] sieves;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        getPrimeNumber();

        String line;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);

            boolean flag = false;

            for (int i = 3; i <= n / 2; i += 2) {
                if (sieves[i] && sieves[n - i]) {
                    sb.append(n).append(" = ").append(i).append(" + ").append(n - i).append("\n");
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                sb.append("Goldbach's conjecture is wrong.").append('\n');
            }
        }

        System.out.println(sb);
    }

    private static void getPrimeNumber() {
        sieves = new boolean[MAX + 1];
        Arrays.fill(sieves, true);
        sieves[0] = sieves[1] = false;

        for (int i = 2; i < (int) Math.sqrt(MAX) + 1; i++) {
            for (int j = i * i; j < MAX + 1; j += i) {
                sieves[j] = false;
            }
        }
    }
}
