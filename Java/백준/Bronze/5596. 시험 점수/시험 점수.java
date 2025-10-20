import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();
        int B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sum();

        if (A >= B) System.out.println(A);
        else System.out.println(B);
    }
}
