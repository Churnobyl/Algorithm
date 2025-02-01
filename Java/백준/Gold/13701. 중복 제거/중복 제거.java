import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int MAX_VALUE = 33554432; // 2^25
        int[] bitSet = new int[MAX_VALUE / 32]; // 비트 배열 (int형 배열 사용)

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            int index = num / 32; // 해당 숫자가 저장될 int 배열의 인덱스
            int bit = 1 << (num % 32); // 해당 숫자의 비트 위치

            if ((bitSet[index] & bit) == 0) { // 아직 등장하지 않은 숫자라면
                bitSet[index] |= bit; // 해당 비트를 켜기
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb.toString().trim()); // 결과 출력
    }
}