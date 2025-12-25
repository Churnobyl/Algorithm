import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = new int[21];

    public static void main(String[] args) throws IOException {
        for (int i = 1; i < 21; i++) {
            arr[i] = i;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            swap(s, e);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 21; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    private static void swap(int s, int e) {
        for (int i = 0; i < (e - s) / 2 + 1; i++) {
            int cache = arr[s + i];
            arr[s + i] = arr[e - i];
            arr[e - i] = cache;
        }
    }
}
