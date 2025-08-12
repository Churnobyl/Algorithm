import java.io.*;
import java.util.*;

public class Main {
    static class Nation implements Comparable<Nation> {
        int id, gold, silver, bronze;

        public Nation(int id, int gold, int silver, int bronze) {
            this.id = id;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Nation o) {
            if (o.gold != this.gold) return Integer.compare(o.gold, this.gold);
            if (o.silver != this.silver) return Integer.compare(o.silver, this.silver);
            if (o.bronze != this.bronze) return Integer.compare(o.bronze, this.bronze);
            return Integer.compare(this.id, o.id);
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        TreeSet<Nation> nations = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations.add(new Nation(id, gold, silver, bronze));
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int cache = 0;
        int rank = 0;

        for (Nation nation : nations) {
            rank++;

            if (a == nation.gold && b == nation.silver && c == nation.bronze) {
                cache++;
            } else {
                cache = 0;
            }

            if (nation.id == K) break;

            a = nation.gold;
            b = nation.silver;
            c = nation.bronze;
        }

        System.out.println(rank - cache);
    }
}