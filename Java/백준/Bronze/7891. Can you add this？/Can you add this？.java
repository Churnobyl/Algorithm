import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            sb.append(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum()).append("\n");
        }
        System.out.println(sb);
    }
}
