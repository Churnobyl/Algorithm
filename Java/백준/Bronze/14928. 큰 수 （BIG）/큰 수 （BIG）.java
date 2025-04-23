import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        final int MOD = 20000303;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        long remainder = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            remainder = (remainder * 10 + digit) % MOD;
        }

        System.out.println(remainder);
    }
}
