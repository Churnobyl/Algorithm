import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long A = info[0];
        long B = info[1];
        long C = info[2];

        System.out.println(modOperation(A, B, C));
    }

    private static long modOperation(long A, long B, long C) {
        if (B == 0) return 1;
        if (B == 1) return A % C;

        long val = modOperation(A, B / 2, C);
        val = val * val % C;
        if (B % 2 == 0) return val;
        return val * A % C;
    }
}