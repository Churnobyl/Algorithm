import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            if (i == 1) {
                System.out.println(" ".repeat(N - i) + "*");
                continue;
            } else if (i == N) {
                System.out.println("*".repeat(N * 2 - 1));
                break;
            }

            System.out.println(" ".repeat(N - i) + "*" + " ".repeat(2 * (i - 1) - 1) + "*");
        }
    }
}