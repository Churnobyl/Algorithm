import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(st.nextToken());
        int diff = Integer.parseInt(st.nextToken());
        
        if (sum < diff) {
            System.out.println(-1);
            return;
        }

        int a = (sum + diff) / 2;

        if ((sum + diff) / 2.0 != (long)((sum + diff) / 2)) {
            System.out.println(-1);
            return;
        }

        int b = (sum - diff) / 2;

        if ((sum - diff) / 2.0 != (long)((sum - diff) / 2)) {
            System.out.println(-1);
            return;
        }

        System.out.println(a + " " + b);
    }
}