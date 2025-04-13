import java.io.*;
import java.util.*;

public class Main {
    static char[] characters;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        characters = br.readLine().toCharArray();
        isUsed = new boolean[characters.length];

        recursive(0, characters.length - 1);
    }

    private static void recursive(int l, int r) {
        if (l > r) return;

        char nextChar = Character.MAX_VALUE;
        int idx = -1;

        for (int i = l; i <= r; i++) {
            if (!isUsed[i] && characters[i] < nextChar) {
                nextChar = characters[i];
                idx = i;
            }
        }

        isUsed[idx] =  true;

        for (int i = 0; i < characters.length; i++) {
            if (isUsed[i]) System.out.print(characters[i]);
        }
        System.out.println();

        recursive(idx + 1, r);
        recursive(l, idx - 1);
    }
}
