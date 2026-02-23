import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine().strip());
        int B = Integer.parseInt(br.readLine().strip());
        System.out.println(B - A);
    }
}
