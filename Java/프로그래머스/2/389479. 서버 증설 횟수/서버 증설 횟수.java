import java.util.*;

class Solution {
    static Queue<Integer> queue = new ArrayDeque<>();
    static int answer, currServerCount;
    static int m, k;
    
    public int solution(int[] players, int m, int k) {
        this.m = m;
        this.k = k;
        
        for (int i = 1; i <= 24; i++) {
            int player = players[i - 1];
            
            checkAvailableServer(i);
            int needServerCount = calcServer(player);
            
            if (currServerCount < needServerCount) {
                addServer(needServerCount, i);
            }
        }
        
        return answer;
    }
    
    private void checkAvailableServer(int time) {
        while (!queue.isEmpty() && queue.peek() < time) {
            queue.poll();
            currServerCount--;
        }
    }
    
    private int calcServer(int player) {
        return player / m;
    }
    
    private void addServer(int needServerCount, int currTime) {
        while (currServerCount < needServerCount) {
            queue.add(currTime + k - 1);
            currServerCount++;
            answer++;
        }
    }
}