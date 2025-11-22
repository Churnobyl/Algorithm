import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int earnWhereAdvertise = e - c;

            if (earnWhereAdvertise > r) {
                sb.append("advertise");
            } else if (earnWhereAdvertise == r) {
                sb.append("does not matter");
            } else {
                sb.append("do not advertise");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}