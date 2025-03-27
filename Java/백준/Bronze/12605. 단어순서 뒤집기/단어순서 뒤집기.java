import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            sb.append("Case #").append(i).append(": ");

            for (int j = s.length - 1; j >= 0; j--) {
                sb.append(s[j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
