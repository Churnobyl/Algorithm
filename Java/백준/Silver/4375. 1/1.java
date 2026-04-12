import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        StringBuilder sb = new StringBuilder();

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) break;

            int n = Integer.parseInt(line);

            int remainder = 1 % n;
            int length = 1;

            while (remainder != 0) {
                remainder = (remainder * 10 + 1) % n;
                length++;
            }

            sb.append(length).append("\n");
        }

        System.out.println(sb);
    }
}