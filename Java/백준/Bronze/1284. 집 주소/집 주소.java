import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("0")) {
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                char t = line.charAt(i);

                if (t == '1') sum += 2;
                else if (t == '0') sum += 4;
                else sum += 3;
            }

            sb.append(sum + line.length() + 1).append("\n");
        }

        System.out.println(sb);
    }
}