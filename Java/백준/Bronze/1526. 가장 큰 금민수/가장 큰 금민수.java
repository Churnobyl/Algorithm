import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static boolean isLucky(int x) {
        while (x > 0) {
            int d = x % 10;
            if (d != 4 && d != 7) return false;
            x /= 10;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        for (int i = n; i >= 4; i--) {
            if (isLucky(i)) {
                System.out.print(i);
                return;
            }
        }
    }
}