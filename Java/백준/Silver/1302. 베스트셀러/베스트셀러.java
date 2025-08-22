import java.io.*;
import java.util.*;

public class Main {
    static Map<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            hashMap.put(line, hashMap.getOrDefault(line, 0) + 1);
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());

        list.sort((e1, e2) -> {
            if (Objects.equals(e1.getValue(), e2.getValue())) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return e2.getValue() - e1.getValue();
        });

        System.out.println(list.get(0).getKey());
    }
}
