import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] order = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> plugged = new HashSet<>();
        int unplugCount = 0;

        for (int i = 0; i < K; i++) {
            int current = order[i];

            if (plugged.contains(current)) continue;

            if (plugged.size() < N) {
                plugged.add(current);
                continue;
            }
            
            int farthest = -1;
            int deviceToUnplug = -1;

            for (int device : plugged) {
                int nextUse = Integer.MAX_VALUE;
                for (int j = i + 1; j < K; j++) {
                    if (order[j] == device) {
                        nextUse = j;
                        break;
                    }
                }

                if (nextUse > farthest) {
                    farthest = nextUse;
                    deviceToUnplug = device;
                }
            }

            plugged.remove(deviceToUnplug);
            plugged.add(current);
            unplugCount++;
        }

        System.out.println(unplugCount);
    }
}
