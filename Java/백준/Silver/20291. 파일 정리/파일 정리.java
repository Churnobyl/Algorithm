import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        TreeMap<String, Integer> answer = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            String a = br.readLine().split("\\.")[1];
            answer.put(a, answer.getOrDefault(a, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : answer.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
