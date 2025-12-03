import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int minA = 0;
        int maxA = 0;
        int minB = 0;
        int maxB = 0;

        for (int i = 0; i < A.length(); i++) {
            char d = A.charAt(i);

            minA *= 10;
            maxA *= 10;

            if (d == '5' || d == '6') {
                minA += 5;
                maxA += 6;
            } else {
                minA += d - '0';
                maxA += d - '0';
            }

        }

        for (int i = 0; i < B.length(); i++) {
            char d = B.charAt(i);

            minB *= 10;
            maxB *= 10;

            if (d == '5' || d == '6') {
                minB += 5;
                maxB += 6;
            } else {
                minB += d - '0';
                maxB += d - '0';
            }
        }

        System.out.println((minA + minB) + " " + (maxA + maxB));
    }
}