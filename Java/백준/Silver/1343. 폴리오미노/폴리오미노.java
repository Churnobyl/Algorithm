import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] line = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < line.length; i++) {
            char data = line[i];

            if (data == '.') {
                if (!check(sb)) {
                    return;
                }

                sb.append(".");
            }
            else {
                cnt++;
            }
        }

        if (!check(sb)) {
            return;
        }

        System.out.println(sb);
    }

    public static boolean check(StringBuilder sb) {
        if (cnt > 0) {
            sb.append("AAAA".repeat(cnt / 4));
            cnt %= 4;
            sb.append("BB".repeat(cnt / 2));
            cnt %= 2;
        }

        if (cnt > 0) {
            System.out.println(-1);
            return false;
        }

        return true;
    }
}