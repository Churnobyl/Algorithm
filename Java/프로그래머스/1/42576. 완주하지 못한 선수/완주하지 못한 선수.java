import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> partMap = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
			partMap.put(participant[i], partMap.getOrDefault(participant[i], 0) + 1);
		}
        
        for (int i = 0; i < completion.length; i++) {
			if (partMap.get(completion[i]) == 1) {
				partMap.remove(completion[i]);
			} else {
				partMap.put(completion[i], partMap.get(completion[i]) - 1);
			}
		}
        
        return (String) partMap.keySet().toArray()[0];
    }
}