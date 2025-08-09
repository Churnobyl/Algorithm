import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new char[N][(2 * N) - 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = ' ';
            }
        }
        fillStar(0, N - 1, N);
        printStar();
    }

    public static void fillStar(int r, int c, int n) {
        if (n == 3) {
            arr[r][c] = '*';
            arr[r + 1][c - 1] = arr[r + 1][c + 1] = '*';
            arr[r + 2][c - 2] = arr[r + 2][c - 1] = arr[r + 2][c] = arr[r + 2][c + 1] = arr[r + 2][c + 2] = '*';
            return;
        }

        int size = n / 2;
        fillStar(r, c, size);
        fillStar(r + size, c - size, size);
        fillStar(r + size, c + size, size);
    }

    public static void printStar() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}