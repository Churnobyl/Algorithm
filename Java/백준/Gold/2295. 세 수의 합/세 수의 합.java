import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	static int N;
	static int[] arr;
	static Integer[] doubArr;
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        Set<Integer> set = new TreeSet<>();
        
        int idx = 0;
        
        for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			
			for (int j = 0; j <= i; j++) {
				set.add(arr[i] + arr[j]);
			}
		}
        
        doubArr = new Integer[set.size()];
        
        Arrays.sort(arr);
        set.toArray(doubArr);
        
        loop1:
        for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				int target = arr[i] - arr[j];
				
				int l = 0;
				int r = doubArr.length - 1;
				
				while (l <= r) {
					int mid = (l + r) / 2;
					if (target == doubArr[mid]) {
						System.out.println(arr[i]);
						break loop1;
					} else if (target > doubArr[mid]) {
						l = mid + 1;
					} else {
						r = mid - 1;
					}
				}
			}
		}
    }
}
