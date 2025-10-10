import java.util.*;

class Solution {
    static Map<String, Integer> id = new HashMap<>();
    static Set<String>[] reported;
    static int[] result;
    static int num;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        setting(id_list);
        run(report, k);
        return result;
    }
    
    public void run(String[] report, int k) {
        for (String r : report) {
            StringTokenizer st = new StringTokenizer(r);
            String from = st.nextToken();
            String to = st.nextToken();
            
            int toIdx = id.get(to);
            reported[toIdx].add(from);
        }
        
        for (int i = 0; i < num; i++) {
            Set<String> rep = reported[i];
            
            if (rep.size() >= k) {
                for (String r : rep) {
                    int idx = id.get(r);
                    result[idx]++;
                }
            }
        }
    }
    
    public void setting(String[] id_list) {
        for (String name : id_list) {
            id.put(name, num++);
        }
        
        reported = new Set[num];
        
        for (int i = 0; i < num; i++) {
            reported[i] = new HashSet<>();
        }
        
        result = new int[num];
    }
}
