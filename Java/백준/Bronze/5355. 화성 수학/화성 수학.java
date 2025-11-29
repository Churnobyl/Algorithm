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
            StringTokenizer st = new StringTokenizer(br.readLine());

            double num = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
                char op = st.nextToken().charAt(0);

                switch (op) {
                    case '@':
                        num *= 3;
                        break;
                    case '%':
                        num += 5;
                        break;
                    case '#':
                        num -= 7;
                }
            }

            sb.append(String.format("%.2f", num)).append("\n");
        }

        System.out.println(sb);
    }
}