import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] data = new int[26];

        String a = br.readLine();
        String b = br.readLine();

        for (int i = 0; i < a.length(); i++) {
            data[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            data[b.charAt(i) - 'a']--;
        }

        int answer = 0;

        for (int i = 0; i < 26; i++) {
            answer += Math.abs(data[i]);
        }

        System.out.println(answer);
    }

}
