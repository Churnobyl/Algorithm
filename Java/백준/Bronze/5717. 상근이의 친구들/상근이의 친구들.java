import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        String line;

        while (!(line = br.readLine()).equals("0 0")) {
            sb.append(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).sum()).append("\n");
        }

        System.out.println(sb);
    }
}
