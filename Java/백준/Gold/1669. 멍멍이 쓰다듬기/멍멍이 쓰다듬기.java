import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());

        long D = Y - X;

        if (D == 0) {
            System.out.println(0);
            return;
        } else if (D == 1) {
            System.out.println(1);
            return;
        }


        long k = 0;
        while (k * k < D) {
            k++;
        }

        if ((k - 1) * k >= D) {
            System.out.println(2 * k - 2);
        } else {
            System.out.println(2 * k - 1);
        }
    }
}
