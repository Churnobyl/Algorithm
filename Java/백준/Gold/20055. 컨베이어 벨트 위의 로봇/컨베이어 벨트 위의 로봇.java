import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int durability;
        boolean haveRobot;
        Node prev, next;

        public Node(int durability) {
            this.durability = durability;
        }
    }

    static class Conveyor {
        int size;
        int count;
        int zeroCount;
        Node load, unload;
        Node head, tail;

        public Conveyor(int size, int[] data) {
            this.size = size;
            setting(data);
        }

        public void setting(int[] data) {
            for (int i = 0; i < size * 2; i++) {
                Node node = new Node(data[i]);
                if (i == 0) {
                    load = node;
                    head = node;
                    tail = node;
                    continue;
                }

                node.prev = tail;
                node.next = head;
                tail.next = node;
                head.prev = node;
                tail = node;

                if (i == size - 1) {
                    unload = node;
                }
            }
        }

        public void rotate() {
            load = load.prev;
            unload = unload.prev;

            // 이동한 즉시 하역할 수 있으면 하역
            if (unload.haveRobot) {
                unload.haveRobot = false;
            }
        }

        public void moveRobot() {
            Node iterator = unload;

            while (iterator != load) {
                if (iterator.prev.haveRobot && !iterator.haveRobot && iterator.durability > 0) {
                    iterator.prev.haveRobot = false;
                    iterator.haveRobot = true;
                    iterator.durability--;

                    if (iterator.durability == 0) zeroCount++;
                }

                iterator = iterator.prev;
            }
        }

        public void loadRobot() {
            if (!load.haveRobot && load.durability > 0) {
                load.haveRobot = true;
                load.durability--;

                if (load.durability == 0) zeroCount++;
            }
        }

        public void unloadRobot() {
            if (unload.haveRobot) {
                unload.haveRobot = false;
            }
        }
    }

    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N * 2];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N * 2; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Conveyor conveyor = new Conveyor(N, arr);
        while (conveyor.zeroCount < K) {
            conveyor.rotate();
            conveyor.moveRobot();
            conveyor.loadRobot();
            conveyor.unloadRobot();
            conveyor.count++;
        }

        System.out.println(conveyor.count);
    }
}