import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        char[] moum = new char[] {'a', 'e', 'i', 'o', 'u'};

        int answer = 0;

        for (int i = 0; i < line.length(); i++) {
            for (int j = 0; j < 5; j++) {
                if (line.charAt(i) == moum[j]) {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}