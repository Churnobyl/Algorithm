import java.util.*;

class Solution {
    static final int MAX = 2500;
    static String[] data;
    static int[] p;
    static List<String> answerList = new ArrayList<>();
    
    public String[] solution(String[] commands) {
        setting();
        
        for (String command : commands) {
            StringTokenizer st = new StringTokenizer(command);
            String com = st.nextToken();
            
            switch (com) {
                case "UPDATE":
                    List<String> data = new ArrayList<>();
                    
                    while (st.hasMoreTokens()) {
                        data.add(st.nextToken());
                    }
                    
                    if (data.size() == 2) {
                        updateAll(data.get(0), data.get(1));
                    } else if (data.size() == 3) {
                        update(Integer.parseInt(data.get(0)) - 1, Integer.parseInt(data.get(1)) - 1, data.get(2));
                    }
                    
                    break;
                case "MERGE":
                    merge(
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1
                    );
                    break;
                case "UNMERGE":
                    unmerge(
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1
                    );
                    break;
                case "PRINT":
                    answerList.add(print(
                        Integer.parseInt(st.nextToken()) - 1,
                        Integer.parseInt(st.nextToken()) - 1
                    ));
                    break;
            }
        }
        
        String[] answer = new String[answerList.size()];
        
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    public String print(int r, int c) {
        int idx = find(r * 50 + c);
        if (data[idx] == null) {
            return "EMPTY";
        }
    
        return data[idx];
    }
    
    public void unmerge(int r, int c) {
        int parent = find(r * 50 + c);
        String value = data[parent];

        List<Integer> group = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            if (find(i) == parent) group.add(i);
        }

        for (int idx : group) {
            p[idx] = idx;
            data[idx] = null;
        }

        data[r * 50 + c] = value;
    }
    
    public void merge(int r1, int c1, int r2, int c2) {
        int idxA = find(r1 * 50 + c1);
        int idxB = find(r2 * 50 + c2);
        
        if (idxA == idxB) return;
        String value = data[idxA] != null ? data[idxA] : data[idxB];
        union(idxA, idxB);
        int root = find(idxA);
        data[root] = value;
    }
    
    public void update(int r, int c, String value) {
        int idx = r * 50 + c;
        int x = find(idx);
        data[x] = value;
    }
    
    public void updateAll(String value1, String value2) {
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < MAX; i++) {
            int root = find(i);
            if (!visited.add(root)) continue;
            if (data[root] != null && data[root].equals(value1)) {
                data[root] = value2;
            }
        }
    }
    
    public int find(int x) {
        if (p[x] == x) return x;
        return p[x] = find(p[x]);
    }
    
    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        
        if (x == y) return;
        p[y] = x;
    }
    
    public void setting() {
        data = new String[MAX];
        p = new int[MAX];
        
        for (int i = 0; i < MAX; i++) {
            p[i] = i;
        }
    }
}