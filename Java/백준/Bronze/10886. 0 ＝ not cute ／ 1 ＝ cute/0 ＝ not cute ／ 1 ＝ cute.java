import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int zero = 0;
        int one = 0;

        for (int i = 0; i < N; i++) {
            if (br.readLine().equals("1")) one++;
            else zero++;
        }

        if (one > zero) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}
