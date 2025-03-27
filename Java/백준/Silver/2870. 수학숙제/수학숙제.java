import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<BigInteger> numbers = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] splits = br.readLine().split("[a-z]+");

            for (String s : splits) {
                if (!s.isEmpty()) {
                    numbers.add(new BigInteger(s));
                }
            }
        }

        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        for (BigInteger num : numbers) {
            sb.append(num).append("\n");
        }

        System.out.print(sb);
    }
}
