import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<Integer> ll = new LinkedList<>();

        for (int i = 1; i < N + 1; i++) {
            int num = Integer.parseInt(st.nextToken());

            ListIterator<Integer> iterator = ll.listIterator();

            while (num > 0) {
                iterator.next();
                num--;
            }

            iterator.add(i);
        }

        ListIterator<Integer> iter = ll.listIterator(N);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            sb.append(iter.previous()).append(" ");
        }

        System.out.println(sb);
    }
}