import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        System.out.println(N - 1946);
    }
}
