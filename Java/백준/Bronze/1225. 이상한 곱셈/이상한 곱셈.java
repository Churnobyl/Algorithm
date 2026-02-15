import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        long d = 0;

        for (int i = 0; i < A.length; i++) {
            int a = A[i] - '0';

            for (int j = 0; j < B.length; j++) {
                int b = B[j] - '0';
                
                d += a * b;
            }
        }

        System.out.println(d);
    }
}
