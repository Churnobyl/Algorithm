import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (i % 2 == 0) sb.append(" ");

            for (int j = 0; j < N; j++) {
                sb.append("* ");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }
}