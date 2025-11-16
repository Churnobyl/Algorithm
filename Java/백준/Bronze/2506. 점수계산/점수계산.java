import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int stack = 1;

        for (int i = 0; i < N; i++) {
            boolean isCorrect = st.nextToken().equals("1");

            if (isCorrect) {
                answer += stack++;
            } else {
                stack = 1;
            }
        }

        System.out.println(answer);
    }
}