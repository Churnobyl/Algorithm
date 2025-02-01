import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int MAX_VALUE = 33554432; // 2^25
        BitSet bitSet = new BitSet(MAX_VALUE);

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (!bitSet.get(num)) {
                bitSet.set(num);
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString().trim()); // 결과 출력
    }
}