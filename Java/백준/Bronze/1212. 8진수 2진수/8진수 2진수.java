import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] octal = br.readLine().toCharArray();

        String[] binary = {
                "000", "001", "010", "011", "100", "101", "110", "111"
        };

        StringBuilder sb = new StringBuilder();

        sb.append(Integer.toBinaryString(octal[0] - '0'));

        for (int i = 1; i < octal.length; i++) {
            sb.append(binary[octal[i] - '0']);
        }

        System.out.println(sb);
    }
}
