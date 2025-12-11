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

            int Y = 0;
            int K = 0;

            for (int j = 0; j < 9; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Y += Integer.parseInt(st.nextToken());
                K += Integer.parseInt(st.nextToken());
            }

            if (Y > K) sb.append("Yonsei");
            else if (Y < K) sb.append("Korea");
            else sb.append("Draw");

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
