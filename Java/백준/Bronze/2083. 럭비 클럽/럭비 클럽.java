import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("# 0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            sb.append(st.nextToken()).append(" ");

            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            if (age > 17 || weight >= 80) {
                sb.append("Senior").append("\n");
            } else {
                sb.append("Junior").append("\n");
            }
        }

        System.out.println(sb);
    }
}
