import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(rev(rev(a) + rev(b)));
    }

    public static int rev(int x) {
        int result = 0;

        while (x != 0) {
            result *= 10;
            result += (x % 10);
            x /= 10;
        }

        return result;
    }
}
