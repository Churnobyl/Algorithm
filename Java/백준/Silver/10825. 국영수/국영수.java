import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        String name;
        int kor, eng, math;

        public Node(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Node o) {
            if (this.kor != o.kor) return Integer.compare(o.kor, this.kor);
            if (this.eng != o.eng) return Integer.compare(this.eng, o.eng);
            if (this.math != o.math) return Integer.compare(o.math, this.math);
            return this.name.compareTo(o.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<Node> set = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            set.add(new Node(name, kor, eng, math));
        }

        StringBuilder sb = new StringBuilder();

        for (Node node : set) {
            sb.append(node.name).append("\n");
        }
        System.out.println(sb);
    }
}
