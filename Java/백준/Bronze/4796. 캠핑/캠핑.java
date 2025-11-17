import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int cnt = 1;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0 0 0")) {
            StringTokenizer st = new StringTokenizer(line);

            int sum = 0;

            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            sum += (V / P) * L;
            sum += Math.min(V % P, L);

            sb.append("Case ").append(cnt++).append(": ").append(sum).append("\n");
        }

        System.out.println(sb);
    }

}
