import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        String target = "UCPC";
        int idx = 0;

        for (int i = 0; i < s.length() && idx < target.length(); i++) {
            if (s.charAt(i) == target.charAt(idx)) {
                idx++;
            }
        }

        if (idx == target.length()) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }
}
