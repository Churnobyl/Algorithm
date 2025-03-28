import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] festival2017 = {0, 5_000_000, 3_000_000, 2_000_000, 500_000, 300_000, 100_000};
    static int[] festival2018 = {0, 5_120_000, 2_560_000, 1_280_000, 640_000, 320_000};
    static int[] f7 = {0, 1, 3, 6, 10, 15, 21};
    static int[] f8 = {0, 1, 3, 7, 15, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int i1 = Arrays.binarySearch(f7, a);
            if (i1 < 0) i1 = - (i1 + 1);
            if (i1 > 6) i1 = 0;

            int i2 = Arrays.binarySearch(f8, b);
            if (i2 < 0) i2 = - (i2 + 1);
            if (i2 > 5) i2 = 0;

            sb.append(festival2017[i1] + festival2018[i2]).append("\n");
        }

        System.out.println(sb);
    }
}
