import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int P1a = Integer.parseInt(st.nextToken());
        int P1b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P2a = Integer.parseInt(st.nextToken());
        int P2b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int P3a = Integer.parseInt(st.nextToken());
        int P3b = Integer.parseInt(st.nextToken());

        int[] a = new int[2];
        int[] b = new int[2];

        a[0] = P2a - P1a;
        a[1] = P2b - P1b;

        b[0] = P3a - P1a;
        b[1] = P3b - P1b;

        int cp = a[0] * b[1] - a[1] * b[0];

        if (cp == 0) System.out.println(0);
        else if (cp > 0) System.out.println(1);
        else System.out.println(-1);
    }
}