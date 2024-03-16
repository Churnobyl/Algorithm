import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            long[] info = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println(calcComputer(info[0], info[1]));
        }
    }

    private static int calcComputer(long a, long b) {
        if (b == 0) return 1;

        long val = calcComputer(a, b / 2);
        val = (val * val) % 10;
        if (b % 2 == 1) val = (val * a) % 10;

        return val == 0 ? 10 : (int)val;
    }
}