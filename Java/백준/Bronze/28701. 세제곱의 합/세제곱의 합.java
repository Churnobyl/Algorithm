import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int A = 0;
        int B = 0;

        for (int i = 1; i <= N; i++) {
            A += i;
            B += (int) Math.pow(i, 3);
        }

        System.out.println(A);
        System.out.println(A * A);
        System.out.println(B);
    }
}
