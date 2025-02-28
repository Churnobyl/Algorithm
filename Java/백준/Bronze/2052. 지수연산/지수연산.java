import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        BigInteger num = BigInteger.valueOf(2).pow(n);
        BigDecimal divide = BigDecimal.ONE.divide(new BigDecimal(num), n, RoundingMode.UNNECESSARY);
        System.out.println(divide.toPlainString());
    }
}
