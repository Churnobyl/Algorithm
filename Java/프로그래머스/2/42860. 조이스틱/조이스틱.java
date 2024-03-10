import java.util.*;

class Solution {
    static int move;
    
    public static int solution(String name) {
        int total = 0;
        move = name.length() - 1; // 
        
        for (int i = 0; i < name.length(); i++) {
            char d = name.charAt(i);
            
            total += Math.min(d - 'A', 'Z' - d + 1);
            
            int aIdx = i + 1;
            
            while (aIdx < name.length() && name.charAt(aIdx) == 'A') {
            	aIdx++;
            }
            
            
            move = Math.min(move, i + name.length() - aIdx + Math.min(i, name.length() - aIdx));
        }
        
        return total + move;
    }
    
    public static void main(String[] args) {
    	
    	for (String string : new String[] {"JEROEN", "JAN", "BBBAAAAAAAAAABBBAAAAAAA"}) {
    		System.out.println(solution(string));			
		}
	}
}