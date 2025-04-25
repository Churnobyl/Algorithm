import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int hour = Integer.parseInt(st.nextToken());
        boolean hasLiquor = st.nextToken().equals("1");

        if (12 <= hour && hour <= 16 && !hasLiquor) {
            System.out.println(320);
        } else {
            System.out.println(280);
        }
    }
}
