import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	static int N, idx, total;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < 11; i++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			total = 0;
			idx = 0;
			
			while (idx < N - 4) {
				if (arr[idx + 2] - Math.max(Math.max(arr[idx], arr[idx + 1]), Math.max(arr[idx + 3], arr[idx + 4])) > 0) {
					total += arr[idx + 2] - Math.max(Math.max(arr[idx], arr[idx + 1]), Math.max(arr[idx + 3], arr[idx + 4]));					
				}
				idx++;
			}
			
			sb.append("#" + i + " " + total + "\n");
		}
		
		System.out.println(sb);
	}
}
