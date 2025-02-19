import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int H, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        H = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        System.out.println(H * 60 + M);
    }
}
