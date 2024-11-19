import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int len = line.length();

        int[][] set = new int[len][26];


        for (int i = 0; i < len; i++) {
            char c = line.charAt(i);

            if (i > 0) {
                set[i] = set[i - 1].clone();
            }

            set[i][c - 'a']++;
        }

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            int c = s[0].charAt(0) - 'a';
            int l = Integer.parseInt(s[1]);
            int r = Integer.parseInt(s[2]);

            if (l < 1) {
                System.out.println(set[r][c]);
            } else {
                System.out.println(set[r][c] - set[l - 1][c]);
            }
        }
    }

}