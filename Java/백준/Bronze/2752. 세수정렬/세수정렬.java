import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < 3; i++) {
            pq.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(pq.poll() + " ");
        }
    }
}
