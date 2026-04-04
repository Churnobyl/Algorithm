import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int starIdx = -1;
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            char c = s.charAt(i);

            if (c == '*') {
                starIdx = i;
                continue;
            }

            int num = c - '0';
            sum += (i % 2 == 0) ? num : num * 3;
        }

        int weight = (starIdx % 2 == 0) ? 1 : 3;

        for (int x = 0; x <= 9; x++) {
            if ((sum + weight * x) % 10 == 0) {
                System.out.println(x);
                return;
            }
        }
    }
}