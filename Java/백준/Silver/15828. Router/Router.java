import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static int N;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        queue = new ArrayDeque<>(N);

        int data = 0;

        while ((data = Integer.parseInt(br.readLine())) != -1) {
            if (queue.size() < N && data > 0) {
                queue.add(data);
            } else if (data == 0) {
                queue.poll();
            }
        }

        if (queue.isEmpty()) System.out.println("empty");
        else {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }
}
