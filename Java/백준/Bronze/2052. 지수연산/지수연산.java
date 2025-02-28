import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String oldOne = "1";
        String newOne = "";

        for (int i = 1; i <= N; i++) {
            newOne = "";
            int remainder = 0;

            for (int j = 0; j < oldOne.length(); j++) {
                int d = oldOne.charAt(j) - '0';

                int num = remainder * 10 + d;

                newOne += num / 2;
                remainder = num % 2;
            }

            if (remainder != 0) {
                newOne += (remainder * 10) / 2;
            }

            oldOne = newOne;
        }

        System.out.println("0." + newOne.substring(1));
    }
}
