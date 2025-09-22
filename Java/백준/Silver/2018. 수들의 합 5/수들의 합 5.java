import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int l = 1;
        int r = 0;
        int sum = 0;
        int cnt = 0;

        while (r <= N) {
            sum += ++r;

            while (sum > N) {
                sum -= l++;
            }

            if (sum == N) cnt++;
        }

        System.out.println(cnt);
    }
}