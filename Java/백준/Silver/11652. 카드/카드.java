import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	static int N;
	static Map<Long, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			Long data = Long.parseLong(br.readLine());
			map.put(data, map.getOrDefault(data, 0) + 1);
		}

		List<Entry<Long, Integer>> list = new ArrayList(map.entrySet());

		Collections.sort(list, new Comparator<Entry<Long, Integer>>() {

			@Override
			public int compare(Entry<Long, Integer> o1, Entry<Long, Integer> o2) {
				if (Integer.compare(o1.getValue(), o2.getValue()) == 0) {
					return Long.compare(o1.getKey(), o2.getKey());
				} else {
					return Integer.compare(o2.getValue(), o1.getValue());
				}
			}
			
		});
		
		System.out.println(list.get(0).getKey());
	}
}