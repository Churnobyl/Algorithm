import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<Character> set = new TreeSet<>();
        String a = "CAMBRIDGE";

        for (int i = 0; i < a.length(); i++) {
            set.add(a.charAt(i));
        }

        String original = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < original.length(); i++) {
            char c = original.charAt(i);

            if (!set.contains(c)) sb.append(c);
        }

        System.out.println(sb);
    }
}