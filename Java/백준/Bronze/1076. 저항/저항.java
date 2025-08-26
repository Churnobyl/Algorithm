import java.io.*;
import java.util.*;

public class Main {
    static Map<String, int[]> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setSetting();
        long result = 0;

        result += map.get(br.readLine())[0] * 10L;
        result += map.get(br.readLine())[0];
        result *= map.get(br.readLine())[1];
        System.out.println(result);
    }

    private static void setSetting() {
        map.put("black", new int[]{0, 1});
        map.put("brown", new int[]{1, 10});
        map.put("red", new int[]{2, 100});
        map.put("orange", new int[]{3, 1_000});
        map.put("yellow", new int[]{4, 10_000});
        map.put("green", new int[]{5, 100_000});
        map.put("blue", new int[]{6, 1_000_000});
        map.put("violet", new int[]{7, 10_000_000});
        map.put("grey", new int[]{8, 100_000_000});
        map.put("white", new int[]{9, 1_000_000_000});
    }
}
