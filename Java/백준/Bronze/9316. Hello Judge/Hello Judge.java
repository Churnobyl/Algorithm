import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N + 1; i++) {
            sb.append("Hello World, Judge ").append(i).append("!").append("\n");
        }

        System.out.println(sb);
    }
}