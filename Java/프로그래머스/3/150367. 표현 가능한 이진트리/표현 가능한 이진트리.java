import java.util.*;

class Solution {
    static int[] answer;
    static int N;
    
    public int[] solution(long[] numbers) {
        setting(numbers);
        
        for (int i = 0; i < N; i++) {
            long num = numbers[i];
            String binary = getBinary(num);
            boolean isCorrect = dfs(binary, 0, binary.length() - 1, binary.charAt(binary.length() / 2) == '1');
            answer[i] = isCorrect ? 1 : 0;
        }
        
        return answer;
    }
    
    public void setting(long[] numbers) {
        N = numbers.length;
        answer = new int[N];
    }
    
    public String getBinary(long num) {
        String binary = Long.toBinaryString(num);
        int originLen = binary.length();
        
        int h = 1;
        while ((int) Math.pow(2, h) - 1 < originLen) h++;
        int maxLen = (int) Math.pow(2, h) - 1;
        
        StringBuilder sb = new StringBuilder();
        sb.append("0".repeat(maxLen - binary.length()));
        sb.append(binary);
        return sb.toString();
    }
    
    public boolean dfs(String binary, int from, int to, boolean isOne) {
        if (from > to) return true;
        int mid = (from + to) / 2;
        
        if (!isOne) {
            if (binary.charAt(mid) == '1') return false;
        }
        
        boolean a = dfs(binary, from, mid - 1, binary.charAt(mid) == '1');
        boolean b = dfs(binary, mid + 1, to, binary.charAt(mid) == '1');
        
        if (!a || !b) return false;
        return true;
    }
}