import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int q1, q2, q3, q4, axis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (x == 0 || y == 0) axis++;
            else if (x > 0 && y > 0) q1++;
            else if (x < 0 && y > 0) q2++;
            else if (x < 0 && y < 0) q3++;
            else q4++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Q1: ").append(q1).append('\n');
        sb.append("Q2: ").append(q2).append('\n');
        sb.append("Q3: ").append(q3).append('\n');
        sb.append("Q4: ").append(q4).append('\n');
        sb.append("AXIS: ").append(axis).append('\n');

        System.out.print(sb);
    }
}
