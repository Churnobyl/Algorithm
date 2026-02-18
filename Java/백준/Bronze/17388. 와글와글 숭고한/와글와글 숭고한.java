import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int sum = s + k + h;

        if (sum >= 100) {
            System.out.println("OK");
            return;
        }

        int min = Math.min(s, Math.min(k, h));
        if (min == s) System.out.println("Soongsil");
        else if (min == k) System.out.println("Korea");
        else System.out.println("Hanyang");
    }
}
