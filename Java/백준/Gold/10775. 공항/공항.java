import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int G, P;
    static int[] gates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        gates = new int[G + 1]; // 1 ~ i번 중 도킹할 수 있는 가장 큰 게이트 번호

        for (int i = 1; i < G + 1; i++) {
            gates[i] = i; // 초기 자신의 게이트 번호로 초기화
        }

        P = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());

            if (docking(gi) == -1) { // 도킹이 더이상 불가능 하다면
                break;
            } else{
                count++;
            }

        }

        System.out.println(count);
    }

    private static int docking(int gi) {
        if (gates[gi] == 0) return -1;

        if (gates[gi] == gi) {
            gates[gi] = gates[gi - 1];
            return gates[gi];
        } else {
            gates[gi] = docking(gates[gi]);
            return gates[gi];
        }
    }
}
