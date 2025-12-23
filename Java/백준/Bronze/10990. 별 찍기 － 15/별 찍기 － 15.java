import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            sb.append(" ".repeat(N - i));
            sb.append("*");

            if (i > 1) {
                sb.append(" ".repeat(2 * i - 3));
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
