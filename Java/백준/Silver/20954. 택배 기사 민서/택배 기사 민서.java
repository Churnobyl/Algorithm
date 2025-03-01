import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int p = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());

            int exp = 0;
            long result = 0;

            if (x == 0) {
                // 원점은 0초에 도달함.
                result = 0;
            } else if (x > 0) {
                exp = findRangeExponent(x);
                result = (long) p * ((int) Math.pow(2, exp))
                        + 4L * ((long) Math.pow(2, exp) - 1)
                        - (((long) Math.pow(2, exp)) - x);
            } else {
                exp = findRangeExponent(-x);
                long baseTime = (long) p * ((int) Math.pow(2, exp))
                        + 4L * ((long) Math.pow(2, exp) - 1)
                        - (((long) Math.pow(2, exp)) - (-x));
                result = baseTime + (1L << (exp + 1));
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    public static int findRangeExponent(int x) {
        int floorExp = Integer.SIZE - Integer.numberOfLeadingZeros(x) - 1;
        if (x != (1 << floorExp)) {
            return floorExp + 1;
        } else {
            return floorExp;
        }
    }
}
