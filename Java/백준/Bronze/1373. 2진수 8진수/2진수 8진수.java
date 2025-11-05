import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binary = br.readLine();

        int len = binary.length();
        int pad = (3 - len % 3) % 3;
        if (pad > 0) binary = "0".repeat(pad) + binary;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < binary.length(); i += 3) {
            String chunk = binary.substring(i, i + 3);
            int oct = Integer.parseInt(chunk, 2); // 2진수 → 10진수
            sb.append(oct);
        }

        System.out.println(sb.toString().replaceFirst("^0+(?!$)", ""));
    }
}
