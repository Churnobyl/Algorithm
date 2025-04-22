import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < 3; i++) {
            set.add(Integer.parseInt(br.readLine()));
        }

        System.out.println(set.toArray()[1]);
    }
}
