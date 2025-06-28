import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(br.readLine());

            BigInteger sum = BigInteger.ZERO;

            for (int j = 0; j < N; j++) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if (sum.compareTo(BigInteger.ZERO) == 0) {
                System.out.println("0");
            } else if (sum.compareTo(BigInteger.ZERO) > 0) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }
}
