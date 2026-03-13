import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int y1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int d1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int y2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int manAge = y2 - y1;
        if (m2 < m1 || (m2 == m1 && d2 < d1)) {
            manAge--;
        }

        int countingAge = y2 - y1 + 1;
        int yearAge = y2 - y1;

        StringBuilder sb = new StringBuilder();
        sb.append(manAge).append('\n');
        sb.append(countingAge).append('\n');
        sb.append(yearAge).append('\n');

        System.out.print(sb);
    }
}