import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] count = new int[41][2];
        count[0] = new int[]{1, 0};
        count[1] = new int[]{0, 1};

        for (int i = 2; i < 41; i++) {
            count[i] = new int[]{count[i - 1][0] + count[i - 2][0], count[i - 1][1] + count[i - 2][1]};
        }

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            System.out.println(count[N][0] + " " + count[N][1]);
        }
    }
}
