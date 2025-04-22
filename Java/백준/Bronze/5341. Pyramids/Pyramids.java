import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> pyramid = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        pyramid.add(0);

        StringBuilder sb = new StringBuilder();

        int a;

        while ((a = Integer.parseInt(br.readLine())) != 0) {
            if (a > pyramid.size() - 1) {
                for (int i = pyramid.size(); i <= a; i++) {
                    pyramid.add(pyramid.get(i - 1) + i);
                }
            }

            sb.append(pyramid.get(a)).append("\n");
        }

        System.out.println(sb);
    }
}
