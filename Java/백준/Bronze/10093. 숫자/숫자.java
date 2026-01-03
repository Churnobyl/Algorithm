import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        if (A > B) {
            int cache = A;
            A = B;
            B = cache;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.max(B - A - 1, 0)).append("\n");

        for (int i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);
    }
}
