import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String maxName = "";
        String minName = "";
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            int transformed = year * 365 + month * 12 + day;

            if (minValue > transformed) {
                minValue = transformed;
                minName = name;
            }

            if (maxValue < transformed) {
                maxValue = transformed;
                maxName = name;
            }
        }

        System.out.println(maxName);
        System.out.println(minName);
    }
}