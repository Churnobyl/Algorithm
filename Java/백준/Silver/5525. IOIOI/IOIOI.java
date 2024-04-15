import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        String S = br.readLine();
        
        int count = 0;
        int matchLength = 0;

        for (int i = 0; i < M; i++) {
            if ((S.charAt(i) == 'I' && matchLength % 2 == 0) || (S.charAt(i) == 'O' && matchLength % 2 == 1)) {
                matchLength++;
                if (matchLength == 2 * N + 1) {
                    count++;
                    matchLength -= 2;
                }
            } else {
                if (S.charAt(i) == 'I') {
                    matchLength = 1;
                } else {
                    matchLength = 0;
                }
            }
        }

        System.out.println(count);
    }
}