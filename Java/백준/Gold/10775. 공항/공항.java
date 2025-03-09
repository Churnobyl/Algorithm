import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int G, P;
    static int[] gates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        G = Integer.parseInt(br.readLine());
        gates = new int[G + 1];

        for (int i = 1; i < G + 1; i++) {
            gates[i] = i; // 본인 게이트와 같은 값일 경우 도킹 가능
        }

        P = Integer.parseInt(br.readLine());

        int count = 0;

        for (int i = 0; i < P; i++) {
            int gi = Integer.parseInt(br.readLine());

            if (docking(gi) == -1) {
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
            int canDock = docking(gates[gi]);
            gates[gi] = canDock;
            return gates[gi];
        }
    }
}
