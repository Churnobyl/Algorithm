import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;

        StringBuilder sb = new StringBuilder();

        while (!(line = br.readLine()).equals("END")) {
            char[] a = line.toCharArray();
            StringBuilder sb2 = new StringBuilder();

            for (int i = 0; i < a.length; i++) {
                sb2.append(a[i]);
            }

            sb.append(sb2.reverse()).append("\n");
        }

        System.out.println(sb);
    }

}
