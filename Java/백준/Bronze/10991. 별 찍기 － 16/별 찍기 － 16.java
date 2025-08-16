import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 1; i < N + 1; i++) {
            System.out.println(" ".repeat(N - i) + "* ".repeat(i));
        }
    }
}
