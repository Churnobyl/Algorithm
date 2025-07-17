import java.io.*;
import java.util.*;

public class Main {
    static int K;
    static int[] counter, idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            counter = new int[26];
            idx = new int[26];
            String line = br.readLine();
            K = Integer.parseInt(br.readLine());
            sb.append(run(line)).append("\n");
        }

        System.out.println(sb);
    }

    private static String run(String line) {
        int shortString = Integer.MAX_VALUE;
        int longString = 0;

        for (int i = 0; i < line.length(); i++) {
            int num = line.charAt(i) - 'a';

            if (counter[num] == 0) {
                idx[num] = i;
            }

            counter[num]++;

            if (counter[num] == K) {
                shortString = Math.min(shortString, i - idx[num] + 1);
                longString = Math.max(longString, i - idx[num] + 1);
                counter[num]--;
                idx[num]++;

                while (idx[num] < line.length() && line.charAt(idx[num]) - 'a' != num) {
                    idx[num]++;
                }

                if (idx[num] == line.length()) {
                    idx[num] = 0;
                }
            }
        }

        if (shortString == Integer.MAX_VALUE && longString == 0) {
            return "-1";
        } else {
            return shortString + " " + longString;
        }
    }
}
