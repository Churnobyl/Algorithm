import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int a = 1;

        StringBuilder sb = new StringBuilder();

        while (a <= N) {
            sb.append("*".repeat(a)).append("\n");
            a++;
        }

        a -= 2;

        while (a > 0) {
            sb.append("*".repeat(a)).append("\n");
            a--;
        }

        System.out.println(sb);
    }
}
