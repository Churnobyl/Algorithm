import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[] arr = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            int pos = Integer.parseInt(st.nextToken());

            if (arr[pos]) cnt++;
            else arr[pos] = true;
        }

        System.out.println(cnt);
    }
}
