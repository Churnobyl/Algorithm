import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int zero = 0;
            int one = 0;

            for (int j = 0; j < 4; j++) {
                if (st.nextToken().equals("0")) {
                    zero++;
                } else {
                    one++;
                }
            }

            if (one == 4) {
                System.out.println("E");
            } else {
                switch (zero) {
                    case 1:
                        System.out.println("A");
                        break;
                    case 2:
                        System.out.println("B");
                        break;
                    case 3:
                        System.out.println("C");
                        break;
                    case 4:
                        System.out.println("D");
                }
            }
        }
    }
}
