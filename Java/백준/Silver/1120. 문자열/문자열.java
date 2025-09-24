import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();

        int minDiff = Integer.MAX_VALUE;

        for (int start = 0; start < B.length() - A.length() + 1; start++) {
            int cnt = 0;

            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) != B.charAt(start + i)) cnt++;
            }

            minDiff = Math.min(cnt, minDiff);
        }

        System.out.println(minDiff);
    }
}