import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();
        char[] B = br.readLine().toCharArray();

        int[][] lcs = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        System.out.println(lcs[A.length][B.length]);

        StringBuilder sb = new StringBuilder();

        int r = A.length;
        int c = B.length;

        while (true) {
            int value = lcs[r][c];

            if (value == 0) break;

            if (value == lcs[r - 1][c]) {
                r -= 1;
            } else if (value == lcs[r][c - 1]) {
                c -= 1;
            } else {
                sb.append(A[r - 1]);
                r -= 1;
                c -= 1;
            }
        }

        System.out.println(sb.reverse());
    }
}
