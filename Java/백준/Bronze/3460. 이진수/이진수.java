import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(n);

            for (int j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '1') sb.append(binary.length() - 1 - j).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}